## Spring Boot and Camunda Multi-Tenant
This project represents starter project for multi-tenant mechanism in Camunda using embedded 
process engine.

Embedded process engine can be replicated but make sure that every engine points to the same database.

### Setting project up
1. Create a database with name `cam-multi-tenant`  
2. Run project

### Artifact Deployment
There are two types of diagrams in this project. You have BPMNs that are common for all tenants, and 
for those diagrams there is auto-deployment setup. You can check parameters in `application.yml` file.

Tenant-specific diagrams are created in `resources -> bpmn -> manual` folder and you can deploy them using
defined REST API service. You can find details bellow:

**URL:** http://localhost:8080/api/process-definition/{tenantId}/deploy  
**Content-Type:** application/multi-part-form-data  
**Method:** POST  
**Request payload:**  file=MultipartFile (BPMN or DMN file)  

**NOTE:** Make sure you provide tenant identifier as path variable. Tenant id is unique identifier of tenant. 

### Testing
1. Enter to the Cockpit and pick up the process that you want to start
2. Check the token in running process instances

### Multiple embedded engines environment
You can replicate this project and start both projects in parallel. Just make sure that both projects
point to the same database. In this way, you can boost performance of Job Executor. Also, in this way you
can achieve High Availability.

### Contribution/Suggestions
If someone is interested in contribution or have some suggestions please contact me on e-mail `hedzaprog@gmail.com`.

### Author
Heril Muratović  
Software Engineer  
<br>
**Mobile**: +38269657962  
**E-mail**: hedzaprog@gmail.com  
**Skype**: hedza06  
**Twitter**: hedzakirk  
**LinkedIn**: https://www.linkedin.com/in/heril-muratovi%C4%87-021097132/  
**StackOverflow**: https://stackoverflow.com/users/4078505/heril-muratovic