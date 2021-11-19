import static java.lang.System.*;

public class Task1 {
    private String msg;
    private int i;
    private int countOperation;

    public Task1() {
        this.msg = "Ping";
    }

    public void runTask(int n) {
        countOperation = n;
        new Thread(() -> {
            synchronized (Task1.class) {
                while (msg.equals("Ping") && n > i) {
                    i++;
                    out.println("WWW-" + "Ping " + i);
                    setMsg("Pong");
                    try {
                        Task1.class.notify();
                        Task1.class.wait();
                        end(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

        new Thread(() -> {
            synchronized (Task1.class) {
                while (msg.equals("Pong") && n > i) {
                    i++;
                    out.println("XXX-" + "Pong " + i);
                    setMsg("Ping");
                    try {
                        Task1.class.notify();

                        Task1.class.wait();
                        end(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();


    }

    private void end(int i) {
        if (i >= countOperation) {
            try {
                notifyAll();
            } catch (IllegalMonitorStateException e) {
                System.exit(0);
            }

        }
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

}
