import java.util.*;

class Graph{
    int Source;
    int Destination;
    int Weight;
}

public class Main {
    public int findParent(int ele, int [] Parent)
    {
        if (Parent[ele] == ele) {
            return ele;
        }
        return findParent(Parent[ele], Parent);
    }

    public void CheckCycle(Graph[] gobj, int EdgesNo, int VertexNo)
    {
        Graph[] Output = new Graph[VertexNo - 1];
        int Count = 0;
        int i = 0;

        int[] Parent = new int[VertexNo];
        for(int k =0; k < VertexNo; k++)
        {
            Parent[k] = k;
        }

        while(Count != VertexNo - 1)
        {
            Graph CurrentNode = gobj[i];
            int SourceParent = findParent(CurrentNode.Source, Parent);
            int DestinationParent = findParent(CurrentNode.Destination, Parent);
            if(SourceParent != DestinationParent)
            {
                Output[Count] = CurrentNode;
                Count++;
                Parent[SourceParent] = DestinationParent;
            }
            i++;
        }
        System.out.println("The Path Present in Graph With There Weights Are : -");
        for(int k = 0; k < EdgesNo; k++)
        {
            System.out.print(gobj[k].Source+"\t");
            System.out.print(gobj[k].Destination+"\t");
            System.out.println(gobj[k].Weight);
        }

        System.out.println("The Path Present in Minimum Cost Spanning With There Weights Are Tree Are : - ");
        for (Graph graph : Output) {
            if (graph.Source < graph.Destination) {
                System.out.print(graph.Source + "\t");
                System.out.print(graph.Destination + "\t");
                System.out.println(graph.Weight);

            } else {
                System.out.print(graph.Destination + "\t");
                System.out.print(graph.Source + "\t");
                System.out.println(graph.Weight);
            }
        }
    }

    public void Reverse(Graph[] gobj, int EdgesNo, int VertexNo)
    {
        int Tsource;
        int Tdestination;
        int Tweight;

        for(int i = 0; i < EdgesNo - 1; i++)
        {
            for(int j = 0; j < EdgesNo-i-1; j++)
            {
                if(gobj[j].Weight > gobj[j+1].Weight)
                {
                    Tsource = gobj[j+1].Source;
                    Tdestination = gobj[j+1].Destination;
                    Tweight = gobj[j+1].Weight;

                    gobj[j+1].Source = gobj[j].Source;
                    gobj[j+1].Destination = gobj[j].Destination;
                    gobj[j+1].Weight = gobj[j].Weight;

                    gobj[j].Source = Tsource;
                    gobj[j].Destination = Tdestination;
                    gobj[j].Weight = Tweight;

                }
            }
        }
        CheckCycle(gobj, EdgesNo, VertexNo);
    }
    public static void main(String[] args) {
	    Scanner sc =new Scanner(System.in);
        int EdgesNo;
        int VertexNo;
        int Source;
        int Destination;
        int Weight;

        System.out.println("Enter the total number of the edges present in the graph = ");
        EdgesNo = sc.nextInt();

        System.out.println("Enter the total number of the vertex present in the graph = ");
        VertexNo = sc.nextInt();

        Graph[] gobj = new Graph[EdgesNo];

        for(int i = 0; i < EdgesNo; i++)
        {
            System.out.println("Enter the source vertex : - ");
            Source = sc.nextInt();
            System.out.println("Enter the destination vertex : - ");
            Destination = sc.nextInt();
            System.out.println("Enter the weight of edge: - ");
            Weight = sc.nextInt();

            gobj[i] = new Graph();
            gobj[i].Source = Source;
            gobj[i].Destination = Destination;
            gobj[i].Weight = Weight;


        }

        Main mobj = new Main();
        mobj.Reverse(gobj, EdgesNo, VertexNo);
    }
}
















