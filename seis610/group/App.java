package seis610.group;

public class App {
	
	public void repChar(char ch, int count)
	{
		for(int i = 0; i < count; i++) System.out.print(ch);
	}

	public static void main(String[] args)
	{
		Evcompra evct1 = new Evcompra();
		Evcompra evct2 = new Evcompra();
		Evcompra x = new Evcompra();
		Evcompra y = new Evcompra();
		Evcompra z = new Evcompra();
		Node tempNode;
		double CROSSRATE = 0.7;
		String oldY, oldZ;
		
		double td[][] = new double[][]{ // data for y = x^2 + 3
				new double[] {-2, -1, 0, 1, 2},
				new double[] {7, 4, 3, 4, 7}	};

//		for(int row = 0; row < td.length; row++)
//		{
//			for(int col = 0; col < td[0].length; col++)
//			{
//				System.out.printf("[%d, %d]", row, col);
//			}
//			System.out.println();
//			for(int col = 0; col < td[0].length; col++)
//			{
//				System.out.printf("[%.1f]", td[row][col]);
//			}
//			System.out.println();
//		}
		//evct1.fillTree(evct1.tree[1]);
		
		System.out.println("\ntd.length = " + td.length);
		
//		for(int i = 1; i < out.tree.length; i++)
//		{ //copy tree, replacing nulls with spaces
//			char v;
//			v = (evct1.tree[i] != null) ? evct1.tree[i].getValue() : ' ';
//			out.tree[i] = new Node(v);
//		}
		

//		for(int i = 0; i < evct1.tree.length ; i++)
//		{
//			if(evct1.tree[i] == null) continue;
//			else
//				{
//					System.out.println("["+ i + "]:" + evct1.tree[i].getValue());
//				}
//
//		}
	
		//evct1.fillTreeStr(evct1.tree[1]);
//		System.out.println("treeStr: " + evct1.treeStr);
//		System.out.println("treeStr eval: " + evct1.getEvalString(5.4));
		
//		x = evct1.copySelf();
//		
//		x.fillTreeStr(x.tree[1]);
//		System.out.println("\nx.treeStr: " + x.treeStr);
		//x.setHeight();
	//	System.out.println("x.tree height = " + x.getHeight());
		
		//System.out.println("x.treeStr eval: " + x.getEvalString(6.2));
		
		evct1.fillTree(evct1.tree[1]);
		evct1.fillTreeStr(evct1.tree[1]);
		System.out.println("evct1 = " + evct1.treeStr);
		
		evct2.fillTree(evct2.tree[1]);
		evct2.fillTreeStr(evct2.tree[1]);
		System.out.println("evct2 = " + evct2.treeStr);
		
		evct1.setFitness(td);
		System.out.println("---------");
		evct2.setFitness(td);
		
		System.out.printf("evct1 fitness = %.2f\n", evct1.getFitness());
		System.out.printf("evct2 fitness = %.2f\n", evct2.getFitness());
		
		//System.out.println("\nevct2.treeStr: " + evct2.treeStr);
		
//		int len = evct2.treeStr.length();
//		for(int i = 0; i < len; i++ )
//		{
//			System.out.print("["+i+"]:" + evct2.treeStr.charAt(i) );
//		}
		
	//	System.out.println("\n****** Testing setHeight() *******");
//		for(int h = 0; h < 128; h++)
//		{
//			if(evct2.tree[h] == null) continue;
//			System.out.print("["+h+"]:" + evct2.tree[h].getHeight() + " " );
//		}
//		System.out.println("\n****** Testing setHeight() *******");
//		
//		System.out.println();
//		//evct2.setHeight();
//		System.out.println("\nevct2.tree height = " + evct2.getHeight());
//		System.out.println();
//		System.out.println("treeStr: " + evct2.treeStr);
//		System.out.println("Evaluate at x = 5.5: " + evct2.evaluate(5.5) );
//		
//		System.out.println("\nTesting mutateTree():\nx.treeStr:  " + x.treeStr);
//		x.mutateTree(x.tree[1]);
//		x.treeStr = "";
//		x.fillTreeStr(x.tree[1]);
//		//System.out.println("x\'.treeStr: " + x.treeStr + "\n**********\n");
//		
//		y = evct1.copySelf();
//		y.fillTreeStr(y.tree[1]);
//		oldY = y.treeStr.substring(0, y.treeStr.length() - 2) + y.treeStr.charAt(y.treeStr.length() - 1);
//		System.out.println("y.treeStr: " + y.treeStr);
//		z = evct2.copySelf();
//		z.fillTreeStr(z.tree[1]);
//		oldZ = z.treeStr.substring(0, z.treeStr.length() - 2) + z.treeStr.charAt(z.treeStr.length() - 1);
//		System.out.println("z.treeStr: " + z.treeStr);
//		
//		System.out.print("\n\n*** Before mutation attempt **\ny tree: ");
//		for(int i = 1; i < 128; i++) if(y.tree[i] != null) System.out.print(y.tree[i].getValue());
//		System.out.print("\nz tree: ");
//		for(int i = 1; i < 128; i++) if(z.tree[i] != null) System.out.print(z.tree[i].getValue());
//		System.out.println("\n\n------------------------");
//		
//		for(int i = 2; i < 128; i++)
//		{
//			if((y.tree[i] != null) && (z.tree[i] != null) &&
//				(Math.random() < CROSSRATE) &&
//				(y.tree[i].getValue() < '0') && (z.tree[i].getValue() < '0'))
//			{
//				System.out.println("Operators y = " + y.tree[i].getValue() + " z = " + z.tree[i].getValue());
//				tempNode = y.tree[i].copySelf();
//				//tempNode = new Node('Q');
//				y.tree[i] = z.tree[i].copySelf();
//				z.tree[i] = tempNode.copySelf();
//				//z.tree[i] = new Node('Q');
//				System.out.println("\n >>> Crossover <<<");
//				System.out.println(y.tree[i].getLeft().getValue() + " < left values > " + z.tree[i].getLeft().getValue());
//				break;
//			}
//		}
//		
//		System.out.print("\n\n*** After mutation attempt **\ny tree: ");
//		for(int i = 1; i < 128; i++) if(y.tree[i] != null) System.out.print(y.tree[i].getValue());
//		System.out.print("\nz tree: ");
//		for(int i = 1; i < 128; i++) if(z.tree[i] != null) System.out.print(z.tree[i].getValue());
//		System.out.println("\n*****************************\n");		
//
//
//		y.treeStr = "";
//		z.treeStr = "";
//		
//		y.fillTreeStr(y.tree[1]);
//		z.fillTreeStr(z.tree[1]);
//		System.out.println("y original: " + oldY);
//		System.out.println("y.treeStr:  " + y.treeStr);
//		System.out.println("\nz original: " + oldZ);
//		System.out.println("z.treeStr:  " + z.treeStr);
		
		
	}

}