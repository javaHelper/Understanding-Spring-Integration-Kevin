# Queue Channel

In this lesson we'll be working with spring Integrations. The queuechannel places each message within a blocking queue that can be pulled by end-points. That invoke the channels receive method. This approach allows messages to be handled asynchronously meaning. The execution of our application does not stop while waiting for a response from a consumer to get started. Will create a Gateway that will will allow us to send and receive messages in order to create a Gateway. 


```
2022-12-09 15:04:20.401  INFO 23530 --- [           main] com.example.demo.Application             : Started Application in 2.226 seconds (JVM running for 3.217)
Sending message 0
Sending message 1
Sending message 2
Sending message 3
Sending message 4
Sending message 5
Sending message 6
Sending message 7
Sending message 8
Sending message 9
2022-12-09 15:04:20.433  INFO 23530 --- [   scheduling-1] o.s.i.h.s.MessagingMethodInvokerHelper   : Overriding default instance of MessageHandlerMethodFactory with provided one.
Coming Payload=Printing message payload for 8
Coming Payload=Printing message payload for 3
Coming Payload=Printing message payload for 4
Coming Payload=Printing message payload for 5
Coming Payload=Printing message payload for 6
Coming Payload=Printing message payload for 1
Coming Payload=Printing message payload for 0
Coming Payload=Printing message payload for 9
>>>> Sending a reply for message 0
>>>> Sending a reply for message 1
Coming Payload=Printing message payload for 2
Coming Payload=Printing message payload for 7
>>>> Sending a reply for message 2
>>>> Sending a reply for message 3
>>>> Sending a reply for message 4
>>>> Sending a reply for message 5
>>>> Sending a reply for message 6
>>>> Sending a reply for message 7
>>>> Sending a reply for message 8
>>>> Sending a reply for message 9

```