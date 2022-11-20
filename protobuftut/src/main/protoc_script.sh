protoc --java_out=java \
  --kotlin_out=kotlin \
  kotlin/proto/search_request.proto \
  --proto_path=kotlin/proto/

protoc --java_out=java \
  --kotlin_out=kotlin \
  kotlin/proto/search_req_enum.proto \
  --proto_path=kotlin/proto/

protoc --java_out=java \
  --kotlin_out=kotlin \
  kotlin/proto/search_response.proto \
  --proto_path=kotlin/proto/

protoc --java_out=java \
  --kotlin_out=kotlin \
  kotlin/proto/error_status.proto \
  --proto_path=kotlin/proto/

protoc --java_out=java \
  --kotlin_out=kotlin \
  kotlin/proto/sample_message.proto \
  --proto_path=kotlin/proto/

protoc --java_out=java \
  --kotlin_out=kotlin \
  kotlin/proto/search_service.proto \
  --proto_path=kotlin/proto/

#The protocol compiler searches for imported files
#in a set of directories specified on the protocol
#compiler command line using the -I/--proto_path flag.
#If no flag was given, it looks in the directory in which the compiler was invoked.
#In general you should set the --proto_path flag to the root of your project and use fully qualified names for all imports.
