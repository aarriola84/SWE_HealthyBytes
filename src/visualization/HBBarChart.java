package visualization;

import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.scene.chart.BarChart;

/**
 * @author Alexis Arriola
 */
public class HBBarChart extends VBox
{
    private int[] favoriteCounts;
    private String[] topFiveNames;
    private String blank = "";
    
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
    private BarChart<String, Number> bc;

    private XYChart.Series[] series;
    
    
    public HBBarChart()
    {
        //create everything
        favoriteCounts = new int[5];
        topFiveNames = new String[5];
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        bc = new BarChart<String, Number>(xAxis, yAxis);
        series = new XYChart.Series[5];
        
        //initialize
        series[0] = new XYChart.Series();
        series[1] = new XYChart.Series();
        series[2] = new XYChart.Series();
        series[3] = new XYChart.Series();
        series[4] = new XYChart.Series();
        
        //sets the size of the bar chart
        bc.setScaleX(.8);
        bc.setScaleY(.8);
        
        //set random values of chart
        favoriteCounts[0] = 5;
        favoriteCounts[1] = 4;
        favoriteCounts[2] = 3;
        favoriteCounts[3] = 2;
        favoriteCounts[4] = 1;
        
        //sets the width of the bars in the graph
        bc.setBarGap(30);

        //set the chart info
        bc.setTitle("Top Recipes");
        xAxis.setLabel("Recipes");
        yAxis.setLabel("Favorite Count");
        
        //this sets the name of the legend
        series[0].setName("Chicken and Dumplings");
        series[1].setName("Fish Tacos");
        series[2].setName("Buckwheat Salad");
        series[3].setName("Mooshoo Pork");
        series[4].setName("Buffalo Chicken Salad");
        
        //
        series[0].getData().add(new XYChart.Data(blank, GetFavoriteCounts()[0]));
        series[1].getData().add(new XYChart.Data(blank, GetFavoriteCounts()[1]));
        series[2].getData().add(new XYChart.Data(blank, GetFavoriteCounts()[2]));
        series[3].getData().add(new XYChart.Data(blank, GetFavoriteCounts()[3]));
        series[4].getData().add(new XYChart.Data(blank, GetFavoriteCounts()[4]));
        
        //
        bc.getData().addAll(series[0], series[1], series[2], series[3], series[4]);
        
        this.getChildren().add(bc);
        this.setAlignment(Pos.CENTER);
    }
    
    /**
     * @return the favoriteCounts
     */
    public int[] GetFavoriteCounts()
    {
        return favoriteCounts;
    }

    /**
     * @param favoriteCounts the favoriteCounts to set
     */
    public void SetFavoriteCounts(int[] favoriteCounts)
    {
        this.favoriteCounts = favoriteCounts;
    }

    /**
     * @return the topFiveNames
     */
    public String[] GetTopFiveNames()
    {
        return topFiveNames;
    }

    /**
     * @param topFiveNames the topFiveNames to set
     */
    public void SetTopFiveNames(String[] topFiveNames)
    {
        this.topFiveNames = topFiveNames;
    }
    
    //functions
    //update fields
    public void UpdateGraph()
    {
        try
        {
            //set names
            if (topFiveNames != null)
            {
                series[0].setName(topFiveNames[0]);
                series[1].setName(topFiveNames[1]);
                series[2].setName(topFiveNames[2]);
                series[3].setName(topFiveNames[3]);
                series[4].setName(topFiveNames[4]);
            }

            //set counts
            if (favoriteCounts != null)
            {
                series[0].getData().add(new XYChart.Data(blank, favoriteCounts[0]));
                series[1].getData().add(new XYChart.Data(blank, favoriteCounts[1]));
                series[2].getData().add(new XYChart.Data(blank, favoriteCounts[2]));
                series[3].getData().add(new XYChart.Data(blank, favoriteCounts[3]));
                series[4].getData().add(new XYChart.Data(blank, favoriteCounts[4]));
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception at HBBarChart, function UpdateGraph: " + e);
        }
        
    }
    
    
}
