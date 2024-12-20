/*
package DesignPatterns.Structural.Adapter;

public class StockDataAdapter {
    private StockDataXML stockDataXML;

    public StockDataAdapter(StockDataXML stockDataXML){
        this.stockDataXML=stockDataXML;
    }

    // Convert XML to JSON
    public JSONObject getJSONData() {
        String xmlData = stockDataXML.getXMLData();
        return XML.toJSONObject(xmlData); // Using org.json.XML to convert
    }
}
*/
