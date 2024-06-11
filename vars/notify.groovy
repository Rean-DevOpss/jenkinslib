import org.devops.Notification

def call(Map params) {
    def notification = new Notification(steps, this)

    try {
        notification.sendTelegram(params.message)
    } catch (Exception e) {
        notification.sendTelegram("Failed to send initial message. Error: ${e.getMessage()}")
    }
}
