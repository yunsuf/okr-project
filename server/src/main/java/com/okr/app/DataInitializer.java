package com.okr.app;

import com.okr.app.model.*;
import com.okr.app.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final ObjectiveRepository objectiveRepository;
    private final KeyResultRepository keyResultRepository;

    public DataInitializer(CompanyRepository companyRepository, 
                          UserRepository userRepository,
                          ObjectiveRepository objectiveRepository,
                          KeyResultRepository keyResultRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.objectiveRepository = objectiveRepository;
        this.keyResultRepository = keyResultRepository;
    }

    @Override
    public void run(String... args) {
        // Create Company
        Company company = new Company();
        company.setName("TechCorp");
        company.setMission("Revolutionize productivity through AI");
        company.setVision("Become the global leader in AI-powered tools");
        company = companyRepository.save(company);

        // Create User
        User user = new User();
        user.setUsername("demo-user");
        user.setRole("TEAM_LEAD");
        user.setCompany(company);
        user = userRepository.save(user);

        // Objective 1: Platform Reliability (Team, Committed)
        Objective obj1 = new Objective();
        obj1.setTitle("Deliver Rock-Solid Platform Reliability");
        obj1.setDescription("Establish ourselves as the most reliable platform in our market segment");
        obj1.setStatus("IN_PROGRESS");
        obj1.setScope("TEAM");
        obj1.setPurpose("COMMITTED");
        obj1.setOwner(user);
        obj1 = objectiveRepository.save(obj1);

        // KR 1.1: Uptime
        KeyResult kr1_1 = new KeyResult();
        kr1_1.setTitle("Achieve 99.99% uptime SLI for core API services");
        kr1_1.setWeight(40);
        kr1_1.setProgress(45);
        kr1_1.setTargetDate(LocalDate.of(2025, 12, 31));
        kr1_1.setType("INCREASING");
        kr1_1.setMinValue(99.95);
        kr1_1.setTargetValue(99.99);
        kr1_1.setMaxValue(99.995);
        kr1_1.setCurrentValue(99.97);
        kr1_1.setMetric("%");
        kr1_1.setObjective(obj1);
        keyResultRepository.save(kr1_1);

        // KR 1.2: MTTR
        KeyResult kr1_2 = new KeyResult();
        kr1_2.setTitle("Reduce Mean Time to Restore (MTTR) from 45min to under 15min");
        kr1_2.setWeight(35);
        kr1_2.setProgress(20);
        kr1_2.setTargetDate(LocalDate.of(2025, 12, 31));
        kr1_2.setType("DECREASING");
        kr1_2.setMinValue(20.0);
        kr1_2.setTargetValue(15.0);
        kr1_2.setMaxValue(10.0);
        kr1_2.setCurrentValue(35.0);
        kr1_2.setMetric("minutes");
        kr1_2.setObjective(obj1);
        keyResultRepository.save(kr1_2);

        // KR 1.3: Change Failure Rate
        KeyResult kr1_3 = new KeyResult();
        kr1_3.setTitle("Lower Change Failure Rate from 12% to below 5%");
        kr1_3.setWeight(25);
        kr1_3.setProgress(60);
        kr1_3.setTargetDate(LocalDate.of(2025, 12, 31));
        kr1_3.setType("PERCENTAGE");
        kr1_3.setMinValue(7.0);
        kr1_3.setTargetValue(5.0);
        kr1_3.setMaxValue(3.0);
        kr1_3.setCurrentValue(7.5);
        kr1_3.setMetric("%");
        kr1_3.setObjective(obj1);
        keyResultRepository.save(kr1_3);

        // Objective 2: Developer Velocity (Team, Aspirational)
        Objective obj2 = new Objective();
        obj2.setTitle("Dramatically Accelerate Development Velocity");
        obj2.setDescription("Empower our engineering team to ship features 3x faster");
        obj2.setStatus("PLANNED");
        obj2.setScope("TEAM");
        obj2.setPurpose("ASPIRATIONAL");
        obj2.setOwner(user);
        obj2 = objectiveRepository.save(obj2);

        // KR 2.1: Lead Time
        KeyResult kr2_1 = new KeyResult();
        kr2_1.setTitle("Reduce Lead Time for Changes from 48h to 8h");
        kr2_1.setWeight(50);
        kr2_1.setProgress(0);
        kr2_1.setTargetDate(LocalDate.of(2025, 9, 30));
        kr2_1.setType("DECREASING");
        kr2_1.setMinValue(12.0);
        kr2_1.setTargetValue(8.0);
        kr2_1.setMaxValue(4.0);
        kr2_1.setCurrentValue(48.0);
        kr2_1.setMetric("hours");
        kr2_1.setObjective(obj2);
        keyResultRepository.save(kr2_1);

        // KR 2.2: Deployment Frequency
        KeyResult kr2_2 = new KeyResult();
        kr2_2.setTitle("Increase deployment frequency from weekly to daily");
        kr2_2.setWeight(50);
        kr2_2.setProgress(15);
        kr2_2.setTargetDate(LocalDate.of(2025, 9, 30));
        kr2_2.setType("INCREASING");
        kr2_2.setMinValue(3.0);
        kr2_2.setTargetValue(5.0);
        kr2_2.setMaxValue(7.0);
        kr2_2.setCurrentValue(1.0);
        kr2_2.setMetric("deploys/week");
        kr2_2.setObjective(obj2);
        keyResultRepository.save(kr2_2);

        System.out.println("Constitution-compliant demo data initialized!");
    }
}
