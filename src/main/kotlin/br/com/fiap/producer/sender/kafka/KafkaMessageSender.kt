package br.com.fiap.producer.sender.kafka

import br.com.fiap.producer.sender.TopicMessageSender
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.kafka.support.SendResult
import org.springframework.util.concurrent.ListenableFutureCallback

@Component
class KafkaMessageSender : TopicMessageSender {

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    override fun sendMessage(topicName: String, message: String) {

        val future = kafkaTemplate.send(topicName, message)

        future.addCallback(object : ListenableFutureCallback<SendResult<String, String>> {

            override fun onSuccess(result: SendResult<String, String>?) {
                println("Sent message=[" + message +
                        "] with offset=[" + result!!.recordMetadata.offset() + "]")
            }

            override fun onFailure(ex: Throwable) {
                println("Unable to send message=["
                        + message + "] due to : " + ex.message)
            }
        })
    }

}

