package Company.Flipkart;


import java.util.*;
import java.util.concurrent.*;

// Enum for GameModes
enum GameMode {
    TWOVTWO(4), FASTDRAW(2), RAID(6);

    private final int requiredPlayers;

    GameMode(int requiredPlayers) {
        this.requiredPlayers = requiredPlayers;
    }

    public int getRequiredPlayers() {
        return requiredPlayers;
    }
}

// Enum for Locations
enum Location {
    CASTLETOWN, AIRBASE, SAVAGELAND
}

// Enum for Ranks
enum Rank {
    BRONZE, SILVER, GOLD, PLATINUM, DIAMOND
}

// Enum for Rank Criteria
enum RankCriteria {
    SAMERANK, ANYRANK
}

// Player class
class Player {
    //player having 2 properties mainly name and rank
    private final String name;
    private final Rank rank;

    public Player(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return name + " (" + rank + ")";
    }
}

// Game class
class Game {
    //for any game we need gameMode, location and players
    private final GameMode gameMode;
    private final Location location;
    private final List<Player> players;

    public Game(GameMode gameMode, Location location) {
        this.gameMode = gameMode;
        this.location = location;
        this.players = new ArrayList<>();
    }

    public boolean addPlayer(Player player) {
        if (players.size() < gameMode.getRequiredPlayers()) {
            players.add(player);
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return players.size() == gameMode.getRequiredPlayers();
    }

    public void startGame() {
        System.out.println("Playing " + gameMode + " game with players: " + players + " in " + location);
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public Location getLocation() {
        return location;
    }

    public List<Player> getPlayers() {
        return players;
    }
}

// MatchRequest class
class MatchRequest {
    private final List<Player> players;//players needed
    private final List<GameMode> gameModes; //gamemode needed
    private final List<Location> locations;// location needed
    private final RankCriteria rankCriteria; // samematch or anymatch needed

    public MatchRequest(List<Player> players, List<GameMode> gameModes, List<Location> locations, RankCriteria rankCriteria) {
        this.players = players;
        this.gameModes = gameModes;
        this.locations = locations;
        this.rankCriteria = rankCriteria;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<GameMode> getGameModes() {
        return gameModes;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public RankCriteria getRankCriteria() {
        return rankCriteria;
    }
}

// Matchmaking Engine class
class MatchmakingEngine {
    private final List<Game> activeGames = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public void processMatchRequest(MatchRequest request) {
        executorService.submit(() -> handleRequest(request));
    }

    private synchronized void handleRequest(MatchRequest request) {
        for (GameMode mode : request.getGameModes()) {
            for (Location location : request.getLocations()) {
                Optional<Game> existingGame = findCompatibleGame(mode, location, request);
                if (existingGame.isPresent()) {
                    Game game = existingGame.get();
                    request.getPlayers().forEach(game::addPlayer);
                    if (game.isFull()) {
                        game.startGame();
                        activeGames.remove(game);
                    } else {
                        System.out.println("Waiting Game with players: " + game.getPlayers());
                    }
                    return;
                }
            }
        }
        // create a new game since no existing game found
        Game newGame = new Game(request.getGameModes().get(0), request.getLocations().get(0));
        request.getPlayers().forEach(newGame::addPlayer);
        activeGames.add(newGame);
        System.out.println("Waiting Game with players: " + newGame.getPlayers());
    }

    private Optional<Game> findCompatibleGame(GameMode mode, Location location, MatchRequest request) {
        return activeGames.stream()
                .filter(game -> game.getGameMode() == mode && game.getLocation() == location && canJoinGame(game, request))
                .findFirst();
    }

    private boolean canJoinGame(Game game, MatchRequest request) {
        if (request.getRankCriteria() == RankCriteria.ANYRANK) {
            return true;
        }
        Rank requestRank = request.getPlayers().get(0).getRank();
        return game.getPlayers().stream().allMatch(player -> player.getRank() == requestRank);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}

// Main class to demonstrate functionality
public class MatchmakingEngineTest {
    public static void main(String[] args) {
        MatchmakingEngine engine = new MatchmakingEngine();

        Player player1 = new Player("player1", Rank.BRONZE);
        Player player2 = new Player("player2", Rank.BRONZE);
        Player player3 = new Player("player3", Rank.BRONZE);
        Player player4 = new Player("player4", Rank.BRONZE);
        Player player5 = new Player("player5", Rank.SILVER);
        Player player6 = new Player("player6", Rank.GOLD);
        Player player7 = new Player("player7", Rank.GOLD);
        Player player8 = new Player("player8", Rank.PLATINUM);
        Player player9 = new Player("player9", Rank.DIAMOND);

        MatchRequest requestA = new MatchRequest(Arrays.asList(player8, player9),
                Arrays.asList(GameMode.FASTDRAW), Arrays.asList(Location.CASTLETOWN, Location.AIRBASE), RankCriteria.ANYRANK);

        MatchRequest requestB = new MatchRequest(Arrays.asList(player1, player2),
                Arrays.asList(GameMode.TWOVTWO), Arrays.asList(Location.CASTLETOWN, Location.AIRBASE), RankCriteria.SAMERANK);

        MatchRequest requestC = new MatchRequest(Arrays.asList(player3),
                Arrays.asList(GameMode.TWOVTWO, GameMode.RAID), Arrays.asList(Location.SAVAGELAND, Location.AIRBASE), RankCriteria.SAMERANK);

        MatchRequest requestD = new MatchRequest(Arrays.asList(player4),
                Arrays.asList(GameMode.TWOVTWO, GameMode.RAID), Arrays.asList(Location.SAVAGELAND, Location.AIRBASE), RankCriteria.ANYRANK);

        MatchRequest requestE = new MatchRequest(Arrays.asList(player5, player6, player7),
                Arrays.asList(GameMode.TWOVTWO, GameMode.RAID), Arrays.asList(Location.SAVAGELAND), RankCriteria.ANYRANK);

        engine.processMatchRequest(requestA);
        engine.processMatchRequest(requestB);
        engine.processMatchRequest(requestC);
        engine.processMatchRequest(requestD);
        engine.processMatchRequest(requestE);

        engine.shutdown();
    }
}
