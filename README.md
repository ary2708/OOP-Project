# Client-Server Authentication

## Run directly via command line

### To build jar files:

Open a command prompt or terminal.

####Client side

Navigate to the client-server-auth directory of the project.

Build the client module by running the following command:
`mvn clean install`

This command will compile the client module, run tests if any, package it into a JAR file, and place it in the target directory of the client module.

####Server Side

Navigate to the ProjectServer directory.

Build the server module by running the following command:
`mvn clean install`

This command will compile the server module, run tests if any, package it into a JAR file, and place it in the target directory of the client module.

### To run the files:

1. Go to ProjectServer directory and run the following command:
`java -jar target/ProjectServer.jar`

2. Go to client-server-auth directory and run:
`java -jar target/ProjectClient.jar`

## How does it work?

1. Start the server.
2. Connect the client with server.
3. Send a message from client to server, server will receive the message.
4. Reply the client with suitable response. The server can send any number of responses.
5. To send a new message from client, start the client again.

Feel free to mention any issues you face.
