package com.example;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    EntryRepository entryRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {


		List<Entry> entries = new LinkedList<Entry>();
		entries.add(new Entry("John", "Smith john.smith@example.com"));
		entries.add(new Entry("Mark", "Johnson mjohnson@example.com"));
		entries.add(new Entry("Michael", "Williams michael.williams@example.com"));
		entries.add(new Entry("Fred", "Miller f.miller@example.com"));
		entries.add(new Entry("Bob", "Brown brown@example.com"));
		entryRepository.save(entries);
	}

}
