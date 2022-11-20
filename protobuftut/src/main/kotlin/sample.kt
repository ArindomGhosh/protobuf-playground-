import com.example.somepackage.*
import com.example.somepackage.ErrorStatusOuterClass.ErrorStatus
import com.example.somepackage.SearchResponseKt.result
import com.google.protobuf.RpcChannel

fun main() {
    val sr: SearchRequest = SearchRequest.newBuilder()
        .setPageNumber(20)
        .setQuery("Arindom")
        .setResultPerPage(50)
//        .setSomeValue(1, "new")
        .build()


    val srq = searchRequest {
        pageNumber = 1
        query = "Arindom"
        resultPerPage = 50
        someValue.addAll(listOf("Arindom", "name"))
        corpus = SearchReqEnum.Corpus.CORPUS_IMAGES
        filters.addAll(listOf(filter {
            keys = "someparam"
            key2 = "anotherparam"
            sequence = 20
        },
            filter {
                keys = "someparam2"
                key2 = "anotherparam2"
                sequence = 360
            },
            filter {
                keys = "someparam3"
                key2 = "anotherparam3"
                sequence = 500
            }))
    }

    val respose = searchResponse {
        results.addAll(
            listOf(
                result {
                    url = "http://localhost/Name"
                    title = "Name"
                },
                result {
                    url = "http://localhost/Name1"
                    title = "Name1"
                },
            )
        )
    }
//    println(srq.filtersList)
//    println(respose.resultsList)
//    srq.toByteArray().forEach(::println)

    val byteArray:ByteArray = srq.toByteArray()

    val decodeReq = SearchRequest.parseFrom(byteArray)
    println("decoded message $decodeReq")

    val errrorStstau: ErrorStatusOuterClass.ErrorStatus? = null

    val sampleMsg = sampleMessage {
        messageOne = messageTypeOne {
            messageOne = "Hello1"
        }
        messageTwo = messageTypeTwo {
            messageTwo = "hello2"
        }
        projects.put(5, "New project")
    }

//    when(sampleMsg.testOnofCase){
//        SampleMessageOuterClass.SampleMessage.TestOnofCase.MESSAGE_ONE -> TODO()
//        SampleMessageOuterClass.SampleMessage.TestOnofCase.MESSAGE_TWO -> TODO()
//        SampleMessageOuterClass.SampleMessage.TestOnofCase.TESTONOF_NOT_SET -> TODO()
//    }
    println(sampleMsg.testOnofCase)
    println(sampleMsg.projectsMap[5])
    println(ErrorStatus.getDescriptor())
    println(ErrorStatus.getDefaultInstance())
}