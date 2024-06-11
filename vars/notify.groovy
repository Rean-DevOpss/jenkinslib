import org.devops.Notification

def call(Map params) {
    return new Notification(steps, this)
}