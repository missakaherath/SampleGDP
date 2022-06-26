package com.example.demo;

import com.example.demo.gdp.GDPs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GdpGrowthApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdpGrowthApplication.class, args);
	}

}
