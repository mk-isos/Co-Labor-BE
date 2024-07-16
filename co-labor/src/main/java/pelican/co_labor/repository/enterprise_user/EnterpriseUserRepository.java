package pelican.co_labor.repository.enterprise_user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pelican.co_labor.domain.enterprise_user.EnterpriseUser;

import java.util.Optional;


@Repository
public interface EnterpriseUserRepository extends JpaRepository<EnterpriseUser, String> {
    @Query("SELECT e FROM EnterpriseUser e WHERE e.enterprise_user_id = :enterpriseUserID")
    Optional<EnterpriseUser> findByEnterpriseUserId(@Param("enterpriseUserID") String enterpriseUserID);
}
