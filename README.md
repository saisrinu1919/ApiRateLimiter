Objective:
    
    To offer users the ability to access the API limited number of times in given sliding window duration. Currently duration is set to 1hour and threshold is set to 10.
        
    Goals: 
        - Limiting the API access to the each tenant in a given time span
        
Technologies:
    
    Tools:
        - Intellij IDE
    Technologies:
        - Language: Java
        - Framework: SpringBoot
        - Database: PostgreSQL
        - Operating System: MacOS
        
Running Service:

    Steps
        - clone repository
            - $git clone https://github.com/saisrinu1919/ApiRateLimiter.git
        - cd to the repo
        - Build the repo
            - $mvn install
        - Jar is created in target folder. Run the following command to start the server
            - $ java -jar target/com.techmojo.APIRateLimiter-1.0-SNAPSHOT.jar  
        - If the server successfull started you can access it 9090 port
            - http://localhost:9090/api/rateLimit/1 should return success
       Note: Make sure posgres server is up.