import org.devops.Notification

def call(Map params) {
    def notification = new Notification(steps, this)
    
    if (params.containsKey('message')) {
        notification.sendTelegram(params.message)
    }
    
    // if (params.containsKey('mailParams')) {
    //     notification.sendMail(params.mailParams)
    // }
}
