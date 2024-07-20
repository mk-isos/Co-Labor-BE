package pelican.co_labor.config.test;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import pelican.co_labor.domain.enterprise.Enterprise;
import pelican.co_labor.domain.enterprise_user.EnterpriseUser;
import pelican.co_labor.domain.job.Job;
import pelican.co_labor.domain.labor_user.LaborUser;
import pelican.co_labor.domain.review.Review;
import pelican.co_labor.repository.enterprise.EnterpriseRepository;
import pelican.co_labor.repository.enterprise_user.EnterpriseUserRepository;
import pelican.co_labor.repository.job.JobRepository;
import pelican.co_labor.repository.labor_user.LaborUserRepository;
import pelican.co_labor.repository.review.ReviewRepository;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private EnterpriseUserRepository enterpriseUserRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private LaborUserRepository laborUserRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @PostConstruct
    public void loadData() {
        // Enterprise 더미 데이터 생성
        Enterprise enterprise1 = new Enterprise();
        enterprise1.setEnterprise_id("1111111111");
        enterprise1.setName("Tech Company");
        enterprise1.setAddress1("서울특별시");
        enterprise1.setAddress2("강동구");
        enterprise1.setAddress3("무슨동");
        enterprise1.setDescription("Leading tech company in the industry.");
        enterprise1.setType("유통");
        enterprise1.setPhone_number("1234-1234");
        enterpriseRepository.save(enterprise1);

        Enterprise enterprise2 = new Enterprise();
        enterprise2.setEnterprise_id("2222222222");
        enterprise2.setName("Data Corp");
        enterprise2.setAddress1("대구광역시");
        enterprise2.setAddress2("달서구");
        enterprise2.setAddress3("진천동");
        enterprise2.setDescription("Innovative data solutions provider.");
        enterprise2.setType("건설");
        enterprise2.setPhone_number("5678-5678");
        enterpriseRepository.save(enterprise2);

        // EnterpriseUser 더미 데이터 생성
        EnterpriseUser enterpriseUser1 = new EnterpriseUser();
        enterpriseUser1.setEnterprise_user_id("John Doe");
        enterpriseUser1.setName("John Doe");
        enterpriseUser1.setEmail("john.doe@techcompany.com");
        enterpriseUser1.setPassword("password123");
        enterpriseUser1.setEnterprise(enterprise1);
        enterpriseUserRepository.save(enterpriseUser1);

        EnterpriseUser enterpriseUser2 = new EnterpriseUser();
        enterpriseUser2.setEnterprise_user_id("Jane Smith");
        enterpriseUser2.setName("Jane Smith");
        enterpriseUser2.setEmail("jane.smith@datacorp.com");
        enterpriseUser2.setPassword("password123");
        enterpriseUser2.setEnterprise(enterprise2);
        enterpriseUserRepository.save(enterpriseUser2);

        // LaborUser 더미 데이터 생성
        LaborUser laborUser1 = new LaborUser();
        laborUser1.setLaborUserId("Alice Johnson");
        laborUser1.setName("Alice Johnson");
        laborUser1.setEmail("alice.johnson@example.com");
        laborUser1.setPassword("password123");
        laborUserRepository.save(laborUser1);

        LaborUser laborUser2 = new LaborUser();
        laborUser2.setLaborUserId("Bob Brown");
        laborUser2.setName("Bob Brown");
        laborUser2.setEmail("bob.brown@example.com");
        laborUser2.setPassword("password123");
        laborUserRepository.save(laborUser2);

//        // Job 더미 데이터 생성
//        Job job1 = new Job();
//        job1.setTitle("Tech Engineer");
//        job1.setDescription("Develop and maintain software solutions.");
//        job1.setViews(100);
//        job1.setDead_date(LocalDate.now().plusDays(30));
//        job1.setEnterprise(enterprise1);
//        job1.setEnterpriseUser(enterpriseUser1);
//        job1.setRequirement("제약조건 1");
//        jobRepository.save(job1);
//
//        Job job2 = new Job();
//        job2.setTitle("Data Scientist");
//        job2.setDescription("Analyze and interpret complex data sets.");
//        job2.setViews(150);
//        job2.setDead_date(LocalDate.now().plusDays(45));
//        job2.setEnterprise(enterprise2);
//        job2.setEnterpriseUser(enterpriseUser2);
//        job2.setRequirement("제약조건 2");
//        jobRepository.save(job2);
//
//        Job job3 = new Job();
//        job3.setTitle("Tech Engineer");
//        job3.setDescription("Develop and maintain software solutions.");
//        job3.setViews(100);
//        job3.setDead_date(LocalDate.now().plusDays(30));
//        job3.setEnterprise(enterprise1);
//        job3.setEnterpriseUser(enterpriseUser1);
//        job3.setRequirement("제약조건 3");
//        jobRepository.save(job3);
//
//        Job job4 = new Job();
//        job4.setTitle("Tech Engineer");
//        job4.setDescription("Develop and maintain software solutions.");
//        job4.setViews(100);
//        job4.setDead_date(LocalDate.now().plusDays(30));
//        job4.setEnterprise(enterprise1);
//        job4.setEnterpriseUser(enterpriseUser1);
//        job4.setRequirement("제약조건 4");
//        jobRepository.save(job4);
//
//        Job job5 = new Job();
//        job5.setTitle("Tech Engineer");
//        job5.setDescription("Develop and maintain software solutions.");
//        job5.setViews(100);
//        job5.setDead_date(LocalDate.now().plusDays(30));
//        job5.setEnterprise(enterprise1);
//        job5.setEnterpriseUser(enterpriseUser1);
//        job5.setRequirement("제약조건 5");
//        jobRepository.save(job5);


        // Review 더미 데이터 생성
        Review review1 = new Review();
        review1.setTitle("Tech Place to Work");
        review1.setRating(5);
        review1.setPromotion_rating(4);
        review1.setSalary_rating(3);
        review1.setBalance_rating(5);
        review1.setCulture_rating(4);
        review1.setManagement_rating(4);
        review1.setPros("Great work-life balance and culture.");
        review1.setCons("Salary could be higher.");
        review1.setLike_count(10);
        review1.setEnterprise(enterprise1);
        review1.setLaborUser(laborUser1);
        reviewRepository.save(review1);

        Review review2 = new Review();
        review2.setTitle("Challenging Environment");
        review2.setRating(4);
        review2.setPromotion_rating(3);
        review2.setSalary_rating(4);
        review2.setBalance_rating(3);
        review2.setCulture_rating(4);
        review2.setManagement_rating(3);
        review2.setPros("Great learning opportunities.");
        review2.setCons("Work-life balance can be challenging.");
        review2.setLike_count(8);
        review2.setEnterprise(enterprise2);
        review2.setLaborUser(laborUser2);
        reviewRepository.save(review2);
    }
}
