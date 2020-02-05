# webhook-demo

This is demo sample application for webhook request sending to third party application who want to get the information. The webhook request will send before and after save method. 

# Run
> POST http://localhost:8080/webhook/save
 {
 	"token":"123456",
 	"url":"http://webhook1.com",
 	"secretKey":"121212",
 	"name":"myWebhook"
 }

I used two ways @Aspect and @Eventlistender for this demo project.
