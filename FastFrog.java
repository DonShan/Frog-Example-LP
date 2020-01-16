public class FastFrog {

    static int firstJump = 5;
    static int firstWait = 1;

    static int secondJump = 3;
    static int secondWait = 2;

    static int thirdJump = 1;
    static int thirdWait = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("FROG GAME");

        System.out.println("Choose one from the following options");
        System.out.println();

        System.out.println("1 Enter Meters");
        System.out.println("2 Enter Duration");
        System.out.println("3 Quit Game");
        System.out.println();

        int num = 0;

        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Invalid Value");
        }

        if (num == 1) {
            System.out.println("Enter the meters");

            int meters = scanner.nextInt();
            checkMeters(meters);
        } else if (num == 2) {
            System.out.println("Enter the duration");

            int duration = scanner.nextInt();
            checkDuration(duration);
        } else if (num == 3) {
            System.exit(0);
        }
    }

    private static void checkMeters(int meters) {
        int mod = meters % (firstJump + secondJump + thirdJump);

        int seconds = 0;
        int nextMeter = 5;

        while (mod > 0) {
            if (nextMeter == firstJump) {
                seconds += 1;
                mod = mod - firstJump;
                nextMeter = 3;

            } else if (nextMeter == secondJump) {
                seconds += 2;
                mod = mod - secondJump;
                nextMeter = 1;

            } else if (nextMeter == thirdJump) {
                seconds += 5;
                mod = mod - thirdJump;
                nextMeter = 5;
            }
        }

        int totalJumps = meters / (firstJump + secondJump + thirdJump);

        int totalDuration = totalJumps * (firstWait + secondWait + thirdWait);

        System.out.println("Duration for jump : " + (totalDuration + seconds) + " Seconds");
    }

    private static void checkDuration(int duration) {
        int mod = duration % (firstWait + secondWait + thirdWait);

        int meters = 0;
        int nextWait = 1;

        while (mod > 0) {
            if (nextWait == firstWait) {
                meters += 5;
                mod -= firstWait;
                nextWait = 2;

            } else if (nextWait == secondWait) {
                meters += 3;
                mod -= secondWait;
                nextWait = 5;

            } else if (nextWait == thirdWait) {
                meters++;
                mod -= thirdWait;
                nextWait = 1;
            }
        }

        int totalTime = duration / (firstWait + secondWait + thirdWait);

        int totalMeters = totalTime * (firstJump + secondJump + thirdJump);

        System.out.println("The Frog Jumped : " + (totalMeters + meters) + " Meters");
    }
}
