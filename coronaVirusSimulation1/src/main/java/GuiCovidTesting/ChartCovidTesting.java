package GuiCovidTesting;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author divya kulkarni
 */

public class ChartCovidTesting extends Application {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    private static Series seriesInfected = new Series();
    private static Series seriesImmune = new Series();
    private static Series seriesDeaths = new Series();
    private static Series seriesSusceptible = new Series();
    Text text = new Text ();
    private static DoubleProperty r_factor_string = new SimpleDoubleProperty (0);


    private Scene scene ;
    private AreaChart<String, Number> areaChart;

    public void showChartWithCovidTesting(double r_factor, int no_of_infected, int no_of_immune,
                                          int no_of_susceptible, int no_of_deaths, int population) {
        Platform.runLater(() -> {
            System.out.println ("r_factor :"+r_factor+" no of infected = " + no_of_infected +
                    " no of immune = " + no_of_immune );
            r_factor_string.set (r_factor);

            Date now = new Date();
            seriesInfected.getData().add(new XYChart.Data(simpleDateFormat.format(now), no_of_infected));
            seriesImmune.getData().add(new XYChart.Data(simpleDateFormat.format(now), no_of_immune));
            seriesDeaths.getData().add(new XYChart.Data(simpleDateFormat.format(now), no_of_deaths));
            seriesSusceptible.getData().add(new XYChart.Data(simpleDateFormat.format(now), no_of_susceptible));
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("");
        // R factor
        Label label = new Label ();
        label.setText ("R Factor: ");
        text.textProperty ().bind (r_factor_string.asString ());

        // AreaChart Data
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis(0, 1100, 5);

        xAxis.setLabel("Time/s");
        yAxis.setLabel("Value");
        //creating the chart
        areaChart = new AreaChart<String, Number> (xAxis,yAxis);

        areaChart.setTitle("CoronaVirus Covid Testing chart");
        //defining a series
        seriesInfected.setName("Infected");
        seriesImmune.setName("Immune");
        seriesDeaths.setName("Deaths");
        seriesSusceptible.setName("Susceptible");
        areaChart.getData().addAll(seriesInfected,seriesImmune,seriesDeaths,seriesSusceptible);
        //areaChart.setPrefSize(280,180);

        GridPane grid = new GridPane ();
        // Setting up R factor position on the screen
        grid.setLayoutX (60);
        grid.setLayoutY (5);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets (25, 25, 25, 25));
        grid.add(label, 0, 1);
        grid.add (text, 1,1);
        Group root = new Group (areaChart,grid);

        scene = new Scene(root,600,400);

        stage.setScene(scene);
        areaChart.prefHeightProperty ().bind (scene.heightProperty ());
        areaChart.prefWidthProperty ().bind (scene.widthProperty ());
        stage.show();

    }
}
