package ir.ac.kntu.report;

import ir.ac.kntu.model.Seller;
import ir.ac.kntu.model.SellerRepository;
import ir.ac.kntu.model.ProductsManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class SellerReportGenerator {

    private final String reportHtmlPath;
    private final String pieChartPath;
    private final String barChartPath;

    public SellerReportGenerator() {
        this("reports/seller_report.html", "reports/seller_pie_chart.png", "reports/seller_bar_chart.png");
    }

    public SellerReportGenerator(String reportHtmlPath, String pieChartPath, String barChartPath) {
        this.reportHtmlPath = reportHtmlPath;
        this.pieChartPath = pieChartPath;
        this.barChartPath = barChartPath;
    }

    public void generateReport() {
        SellerRepository sellerRepo = SellerRepository.getSinstance();
        List<Seller> sellers = sellerRepo.getAllSellers();

        try {
            createPieChart(sellers);
            createBarChart(sellers);
            createHtmlReport(sellers);
            System.out.println("The sellers report was successfully created at: " + reportHtmlPath);
        } catch (IOException e) {
            System.err.println("Error in creating report: " + e.getMessage());
        }
    }

    private void createPieChart(List<Seller> sellers) throws IOException {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Seller seller : sellers) {
            double amount = seller.getSellerWallet().getInventory();
            if (amount > 0) {
                String label = seller.getFirstName() + " " + seller.getLastName();
                dataset.setValue(label, amount);
            }
        }

        JFreeChart pieChart = ChartFactory.createPieChart(
                "نمودار موجودی فروشندگان", dataset, true, true, false);

        pieChart.setBackgroundPaint(Color.WHITE);
        pieChart.setTitle(new TextTitle("نمودار موجودی فروشندگان", new Font("Tahoma", Font.BOLD, 18)));
        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setLabelFont(new Font("Tahoma", Font.PLAIN, 14));
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0}: {1} دلار ({2})",
                new DecimalFormat("#,##0.00"),
                new DecimalFormat("0.0%")
        ));
        ChartUtils.saveChartAsPNG(new File(pieChartPath), pieChart, 640, 480);
    }

    private void createBarChart(List<Seller> sellers) throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Seller seller : sellers) {
            double inventory = seller.getSellerWallet().getInventory();
            String label = seller.getFirstName() + " " + seller.getLastName();
            dataset.addValue(inventory, "موجودی", label);
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "مقایسه موجودی فروشندگان",
                "فروشنده",
                "موجودی (دلار)",
                dataset
        );
        barChart.setBackgroundPaint(Color.WHITE);
        barChart.setTitle(new TextTitle("نمودار میله‌ای موجودی فروشندگان", new Font("Tahoma", Font.BOLD, 18)));
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(79, 129, 189));
        renderer.setDrawBarOutline(false);
        ChartUtils.saveChartAsPNG(new File(barChartPath), barChart, 800, 500);
    }

    private void createHtmlReport(List<Seller> sellers) throws IOException {
        try (FileWriter writer = new FileWriter(reportHtmlPath)) {
            writer.write("<!DOCTYPE html>\n<html lang='fa'>\n<head>\n");
            writer.write("<meta charset='UTF-8'>\n<meta name='viewport' content='width=device-width, initial-scale=1'>\n<title>گزارش مالی فروشندگان</title>\n");
            writer.write("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.rtl.min.css' rel='stylesheet'>\n<style>\n");
            writer.write("body { direction: rtl; padding: 30px; background-color: #f0f2f5; font-family: Tahoma, sans-serif; }\nh1, h3 { text-align: center; color: #212529; }\n");
            writer.write(".card { background: white; border-radius: 20px; box-shadow: 0 6px 20px rgba(0,0,0,0.08); padding: 20px; margin-bottom: 40px; }\n");
            writer.write("table { background-color: white; border: 1px solid #dee2e6; }\nth { background-color: #0d6efd; color: white; }\nth, td { text-align: center; vertical-align: middle; }\n");
            writer.write("img { display: block; margin: 30px auto; border-radius: 10px; max-width: 100%; }\n</style>\n</head>\n<body>\n<div class='container'>\n");
            writer.write("<div class='card'>\n<h1 class='mb-4'>گزارش مالی فروشندگان</h1>\n<table class='table table-bordered table-striped'>\n<thead>\n<tr>\n");
            writer.write("<th>نام</th><th>نام خانوادگی</th><th>نام فروشگاه</th><th>استان</th><th>موجودی(دلار)</th><th>تعداد محصولات فروش</th><th>مجموع فروش</th>\n</tr>\n</thead>\n<tbody>\n");
            for (Seller seller : sellers) {
                writer.write("<tr>\n");
                writer.write("<td>" + seller.getFirstName() + "</td>\n");
                writer.write("<td>" + seller.getLastName() + "</td>\n");
                writer.write("<td>" + seller.getStoreTitle() + "</td>\n");
                writer.write("<td>" + seller.getProvinceOfSale() + "</td>\n");
                writer.write("<td>" + String.format("%.2f", seller.getSellerWallet().getInventory()) + "</td>\n");
                writer.write("<td>" + ProductsManager.getInstance().getProductss(seller).size() + "</td>\n");
                writer.write("<td>" + String.format("%.2f", seller.getSellerWallet().getInventory()) + "</td>\n</tr>\n");
            }
            writer.write("</tbody>\n</table>\n</div>\n<div class='card'>\n<h3>نمودار سهم فروشندگان از موجودی</h3>\n");
            writer.write("<img src='seller_pie_chart.png' alt='نمودار دایره‌ای موجودی فروشندگان'>\n</div>\n<div class='card'>\n<h3>نمودار مقایسه‌ای موجودی</h3>\n");
            writer.write("<img src='seller_bar_chart.png' alt='نمودار میله‌ای موجودی فروشندگان'>\n</div>\n</div>\n</body>\n</html>\n");
        }
    }
}
