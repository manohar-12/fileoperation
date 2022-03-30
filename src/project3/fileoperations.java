package project3;
import java.util.Scanner;
import java.io.*;
public class fileoperations {
	public static void main(String[] args)  {
		Scanner sc =new Scanner(System.in);
		char c;
		System.out.println("Enter your operation of a file:(Read:r/Write:w/Append:a):");
		c=sc.next().charAt(0);
		Scanner sc3=new Scanner(System.in);
		System.out.println("Enter the file name to perform operation:");
		String file=sc3.nextLine();
			 switch(c) {
			 case 'w':{
				 Scanner sc1=new Scanner(System.in);
				try {
					System.out.println("enter the text to write in your file");
					String s;
					s=sc1.nextLine();
					FileWriter writer =new FileWriter(file);
					
					writer.write(s);
					writer.close();
					System.out.println("file written sucessfully..........");
					
				} catch (IOException e) {
					System.out.println("error occured:");
				}
				sc1.close();
				break;
			}
			case 'r': {
				try {
					FileReader reader=new FileReader(file);
					int data;
						while((data=reader.read())!=-1) {
							System.out.print((char)data);
						}
					reader.close();
					System.out.println("\nFile readed sucessfully.........");
				}catch (IOException e) {
					
					System.out.println("file not found");
				}
				break;
			}
			case 'a':{
				Scanner sc2=new Scanner(System.in);
				try {
					
				BufferedReader reader =new BufferedReader(new FileReader(file));
				String line=reader.readLine();
				reader.close();
				System.out.println("enter the text to append:");
				String text=sc2.nextLine();
				String newdata="";
				newdata+=line+" "+text;
				FileWriter writer =new FileWriter(file);
				writer.write(newdata);
				writer.close();
				System.out.println("File appended sucessfully........");
				}catch (Exception e) {
					System.out.println("Exception occured while appending ");
				}
				sc2.close();
				break;
				
			}
			default:
				System.out.println("Enter (r/w/a) only");
				break;
			}
			sc.close();
			sc3.close();
	}

}
