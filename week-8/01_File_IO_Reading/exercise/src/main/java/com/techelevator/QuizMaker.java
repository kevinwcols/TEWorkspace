package com.techelevator;

import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {
			String q1 = "What color is the sky?\n" + "(a)Yellow\n(b)Blue\n(c)Green\n(d)Red\n";
			String q2 = "What are the Cleveland Browns' odds of winning a championship?\n" + "(a)Not Likely\n(b)Highly Likely\n(c)Fat Chance\n(d)Who Cares??\n";
			String q3 = "A skeleton walks into a bar, & says to the bartender,\"Give me a beer & a ...?\"\n" + "(a)Hair Brush\n(b)Dry Erase Marker\n(c)Mop\n(d)Yo-Yo\n";

			Question[] questions = {
					new Question(q1,"b"),
					new Question(q2,"a"),
					new Question(q3,"c")
			};
			takeTest(questions);
		}
		public static void takeTest(Question[] questions) {
			int score = 0;
			Scanner keyboardInput = new Scanner(System.in);
			for(int i = 0; i < questions.length; i++) {
				System.out.println(questions[i].prompt);
				String answer = keyboardInput.nextLine();
				if(answer.equals(questions[i].answer)) {
					score++;
				}
			}
			System.out.println("\nYou scored " + score + "/" + questions.length);
			System.out.println("\nCorrect Answers are: \n1.) b\n2.) a\n3.) c");
			keyboardInput.close();
		}

	}
