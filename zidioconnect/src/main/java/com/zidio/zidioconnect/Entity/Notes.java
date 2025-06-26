package com.zidio.zidioconnect.Entity;

public class Notes {
 
	/* 
	 * 
	 *   frist creat user then recuriter then job .  
	 *    but in job we use recruiterid that is error in that class error is recruiterid not genreated 
	 * */
	// login and registration ki entity  koi need  nahi he kquki muje data he wo user class se milega usko check krna he .
	
	/*This tells ModelMapper:

"PropertyMap<StudentProfile, StudentProfileDto> studentMap = new PropertyMap<>() {
    @Override
    protected void configure() {
        map().setUserId(source.getUser().getId());
    }
};
When you convert a StudentProfile object to a StudentProfileDto, take the nested value getUser().getId() from StudentProfile, and set it as setUserId() in StudentProfileDto."*/
}
/*Apply for a Job
   POST http://localhost:8080/api/applications/apply
 Enter this:
{
  "studentEmail": "mahesh@example.com",
  "jobId": 101
}
output If successful, you'll get a response like:

{
  "id": 1,
  "studentEmail": "mahesh@example.com",
  "jobId": 101,
  "status": "Applied"
}
 
 
 
 Get All Applications for a Student
GET http://localhost:8080/api/applications/student/mahesh@example.com


Get All Applications for a Job
GET http://localhost:8080/api/applications/job/101




-------------------------------------------------------------------------------------------------------------------
ADMIN---

PUT http://localhost:8080/api/admin/user/status

{
  "email": "admin@example.com",
  "isActive": true
}
GET http://localhost:8080/api/admin/users

GET http://localhost:8080/api/admin/users/STUDENT






-------------------------------------------------------------------------------------------------------------------

Why No Entity/Repository for Email and File Upload?
🔸 Email Sending:
You are not storing emails into the database.

You are just sending it using JavaMailSender (SMTP protocol).

So:

No need for JPA Entity

No need for Repository

But if you wanted to track sent emails, then yes – you would need an EmailLog Entity + Repository.



-------------------------------------------------------------------------------------------------------------------
File Upload:
Files are stored in the file system (like uploads/resumes) — not in the database.

So:

❌ No Entity

❌ No Repository

But again, if you wanted to save file metadata (file name, user, time uploaded) → you’d need an Entity and DB table.


Flow of Email Sending (without Entity)

POST /api/notifications/send → EmailController → EmailService → JavaMailSender (SMTP) → ✅ Email sent!


Flow of File Upload (without Entity)
POST /api/file/upload → FileUploadController → FileUploadService → Files saved on disk





-------------------------------------------------------------------------------------------------------------------
Purpose of FileUploadService Class
This class is a Spring Boot service used to handle file upload functionality in your project. Specifically, it:

✔ Uploads files (e.g. resumes, images) from frontend to the backend server
✔ Stores the files on your local machine/server
✔ Returns the URL path where the file is stored (e.g., /files/mahesh_resume.pdf)

Step-by-Step Flow
🔹 1. Frontend Sends a File it comes as a MultipartFile

🔹2. Spring Boot Calls this Service--->String url = fileUploadService.upload(file);


🔹 3. Creates Folder (if not exists)

if (!Files.exists(path)) {
    Files.createDirectories(path);
}  
Creates the folder where files will be stored — using the path in:@Value("${file.upload-dir}")
																  private String uploadDir;

This comes from your application.properties file: file.upload-dir=upload/resumes


🔹 4. Generates Unique File Name--->String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

🔹 5. Saves the File to Disk--->Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

🔹 6. Returns File Access Path--->return "/files/" + fileName;

✅ API Call via Postman: (POST URL) http://localhost:8080/api/file/upload



-------------------------------------------------------------------------------------------------------------------------------------------------------------------
How To Test in Postman Send Email

POST http://localhost:8080/api/notifications/send


{
  "to": "someone@gmail.com",
  "subject": "Test Email",
  "message": "This is a test email from job portal"
}
 Upload File:
POST http://localhost:8080/api/file/upload
Form-Data:
Key: file   Value: Choose File (PDF/Doc)

Download File

GET /api/file/{fileName}   in gitbash


































 */