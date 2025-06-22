package
com.zidio.zidioconnect.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NegativeOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class JobListing {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "recruiter_id", nullable = false)
	    private Recruiter recruiter;

	    @Column(nullable = false, length = 100)
	    private String title;

	    @Column(nullable = false, length = 500)
	    private String description;

	    @Column(nullable = false, length = 100)
	    private String location;

	    @Column(nullable = false, length = 50)
	    private String type; // e.g. "Internship" or "Job"

	
	
	
}
