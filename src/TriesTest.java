import samplePackage.Tries;

//$Id$

public class TriesTest
{
	public static void main(String... args)throws Exception
	{
		Tries tries =  new Tries();
		/*tries.buildTrie("premk");
		tries.buildTrie("prema");
		tries.buildTrie("prabu");
		tries.buildTrie("anuja");*/
		//System.out.println(tries.longestRepeatingSubString("GeeksForGeeks.com"));
		System.out.println(tries.longestRepeatingSubString("GeeksGeeks"));
		//tries.printTree();
	}
}
