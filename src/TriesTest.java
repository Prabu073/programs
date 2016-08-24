import samplePackage.Tries;

public class TriesTest
{
	public static void main(String... args)throws Exception
	{
		Tries tries =  new Tries();
		System.out.println(tries.longestRepeatingSubString("GeeksForGeeks.com"));
		System.out.println(new Tries().longestRepeatingSubString("Geeks"));
	}
}
