public class MovingAverage {
  private static int min = 1000; // stores the minimum int in MovingAverage objects.
  private static int max = 0; // stores the maximum int in MovingAverage objects.
  private double sum; // stores the sum of the numbers in MovingAverage objects.
  private int NumItems; // counts the number of items that are added in the object.
  private int N_value = 0; // the window size for calculating average of numbers in that particular window.
  private int[] NumStorage; // An array that stores the most recent N numbers that are in the object.
  private int count = 0; // count is used as a counter for adding and replacing the integers in the
                         // NumStorage.

  /**
   * Constructs the MovingAverage object which calculates the average of the
   * numbers in the object.
   */
  public MovingAverage() {
    this.sum = 0;
    this.NumItems = 0;
  }

  /**
   * Constructs the MovingAverage object which calculates the average of the
   * recent most 'N' numbers in the object.
   */
  public MovingAverage(int N) {
    this.sum = 0;
    this.NumItems = 0;
    this.N_value = N;
    this.NumStorage = new int[N];
    for (int i = 0; i < N; i++) {
      NumStorage[i] = 0;
    }
  }

  /**
   * This static method that returns the minimum int in the object.
   */
  public static int min() {
    return min;
  }

  /**
   * This static method that returns the maximum int in the object.
   */
  public static int max() {
    return max;
  }

  /**
   * This non-static method that adds the given number to the object and/or stores
   * the most N recent numbers to NumStorage if a window size is given.
   */

  public void add(int x) {

    if (this.N_value == 0) {
      this.sum = sum + x;
    } else {
      if (this.count == this.N_value) {
        this.count = 0;
      }
      NumStorage[this.count] = x;
      this.count = this.count + 1;
    }

    this.NumItems = NumItems + 1;
    if ((max == 0) && (min == 0)) {
      max = x;
      min = x;
    } else if (x > max) {
      max = x;
    } else if (x < min) {
      min = x;
    }
  }

  /**
   * This non-static method that returns the average of all the numbers in the
   * object and/or the most recent N numbers if the window size is given.
   */

  public double avg() {
    double average;
    if (this.NumItems == 0) {
      average = 0.0;
    } else if (this.N_value == 0) {
      average = (this.sum) / this.NumItems;
    } else {
      this.sum = 0;
      for (int i = 0; i < this.N_value; i++) {
        this.sum = this.sum + NumStorage[i];
      }
      if (this.NumItems >= this.N_value) {
        average = (this.sum) / this.N_value;
      } else {
        average = (this.sum) / this.NumItems;
      }

    }
    return average;
  }
}