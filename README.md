# JMS with  Wildfly


## Starting the server 
#### Starting standalone-full

Provide the `standalone-full` in order to get the `messaging` subsystem, otherwise 
JMS will not be available when you start the server. 
    
    ./standalone.sh -c standalone-full.xml

## Creating the QUEUE
    ./jboss-cli --connect
    
    /subsystem=messaging-activemq/server=default/jms-queue=CleriosQueue:add(entries=[java:/jms/queue/CleriosQueue])

#### Using Resources
        
        http://localhost:8080/jms-in-wildfly/jmswildfly/api/generics