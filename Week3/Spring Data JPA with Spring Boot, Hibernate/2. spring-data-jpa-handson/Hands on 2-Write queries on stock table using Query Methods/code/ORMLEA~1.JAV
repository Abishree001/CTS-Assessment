package com.example.ormlearntwo;

import com.example.ormlearntwo.model.Stock;
import com.example.ormlearntwo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrmlearntwoApplication implements CommandLineRunner {

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmlearntwoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("🔍 Facebook Stocks (Sep 2019):");
        Date start = sdf.parse("2019-09-01");
        Date end = sdf.parse("2019-09-30");
        List<Stock> fbStocks = stockRepository.findByCodeAndDateBetween("FB", start, end);
        fbStocks.forEach(this::printStock);

        System.out.println("\n🔍 Google Stocks where close > 1250:");
        List<Stock> googleStocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250);
        googleStocks.forEach(this::printStock);

        System.out.println("\n🔍 Top 3 Highest Volume Stocks:");
        List<Stock> topVolume = stockRepository.findTop3ByOrderByVolumeDesc();
        topVolume.forEach(this::printStock);

        System.out.println("\n🔍 Netflix Lowest 3 Closing Prices:");
        List<Stock> lowestNetflix = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        lowestNetflix.forEach(this::printStock);
    }

    private void printStock(Stock stock) {
        System.out.printf("%s | %s | %.2f | %.2f | %d\n",
                stock.getCode(), stock.getDate(), stock.getOpen(), stock.getClose(), stock.getVolume());
    }
}
