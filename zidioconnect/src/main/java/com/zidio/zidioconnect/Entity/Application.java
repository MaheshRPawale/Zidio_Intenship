package com.zidio.zidioconnect.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Application{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

private Long id;

private String sudentEmail;
private Long jobId;

private String status;

}
