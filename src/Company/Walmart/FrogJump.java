package Company.Walmart;

import java.util.*;

public class FrogJump {
    public static boolean canCross(int[] stones) {
        // Create a map where each stone maps to a set of possible jump lengths.
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        // The frog starts on the first stone with a jump of 0.
        map.get(stones[0]).add(0);

        // Iterate through each stone.
        for (int stone : stones) {
            for (int jump : map.get(stone)) {
                // For each possible jump, consider the next jumps (k-1, k, k+1).
                for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {
                    if (nextJump > 0 && map.containsKey(stone + nextJump)) {
                        map.get(stone + nextJump).add(nextJump);
                    }
                }
            }
        }
        System.out.println(map);

        // If the last stone has any jump lengths recorded, the frog can reach it.
        return !map.get(stones[stones.length - 1]).isEmpty();
    }

    public static void main(String[] args) {
        int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(canCross(stones)); // Output: false
    }
}

/*
//array having numbers [1,2,2]

distribute candy
each having one candy


1,2,2

//sort based on ranking
//map<ranking, candy>

1-1
2-1+1
2-1+1

minElement

candy

1 2 2
1 1 1

a[i]>a[i-1]
cand[i]=cand[i-1]+1;




1 2 2 1
1 2 2

[1,0,2,3,1]
 2 1 2 4 1


int n=arr.length;
int cand[]=new int[n];
//initalli all with 1
Arrays.fill(cand,1);// [1, 1, ,1, 1,1]

//l->r
for(int i=1;i<n;i++){
	if(arr[i]>arr[i-1]){
		cand[i]=cand[i-1]+1;
	}
}


//r->l
for(int i=n-2;i>=0;i--){
	if(arr[i]>ar[i+1]){
		cand[i]=max(cand[i],cand[i+1]+1)
		//cand[i]=cand[i+1]+1;

	}
}

return cand.stream().sum();


//i=2
1 1 2 1 1
[1,0,2,3,1]
1 1 2 3 1

i=1
2 1 2 4 1=10

PriorityQueue<Interg> pq=new PriorityQueue<>();

max heap
2 3 1 5

2 3 1            5 6
2 3     1        5    6
2   3


1 2 3            5 6

1 2 3 5 6


2 3 1 5


max heap
 6
4 5

============

[0,1,2,3,4,8,9,11]
frog

in starting one unit
0 1 2 3 4 8 9 11
      f

0 1 2 3 4 8 9 11
      f

0 1 2 3 4 8 9 11
  f

//possible values jump
map<int, set<int>> map=new HashMap<>();
for(int num: arr){
	map.put(num, new HashSet<>());
}
map.put(arr[0], 0);
0, 1
1, 1
2, 1,2
3  1,2,3
4  1,2,3,4
8
9
11
====



//int starting 1
for(int num: arr){
	for(int possibleValues: map.get(num)){
		for(int j=possibleValue-1;j<=possibleValues+1;j++){//-1 to 1
			//going forward
			if(j>0 && map.containsKey(num+j)){
				//map.get(3+1).add(1);
				map.get(num+j).add(j);
			}
		}
	}
}
return !map.get(arr[arr.length-1]).size()==0;















 */
