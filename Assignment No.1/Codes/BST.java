import java.util.*;

class node{
    int Data;
    node left;
    node right;
}

public class BST {
    public node CreateNode(int iNo)
    {
        node NODE = new node();
        NODE.left = null;
        NODE.Data = iNo;
        NODE.right = null;
        return NODE;
    }

    public node Insert(node root, int iNo)
    {

        if(root == null)
        {
            return CreateNode(iNo);
        }
        else if (iNo < root.Data)
        {
            root.left = Insert(root.left, iNo);
        }
        else if(iNo > root.Data)
        {
            root.right = Insert(root.right, iNo);
        }
        return root;
    }

    public void PreOrder(node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.println(root.Data);
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public void PostOrder(node root)
    {
        if(root == null)
        {
            return;
        }
        PreOrder(root.left);
        PreOrder(root.right);
        System.out.println(root.Data);
    }

    public void InOrder(node root)
    {
        if(root == null)
        {
            return;
        }
        PreOrder(root.left);
        System.out.println(root.Data);
        PreOrder(root.right);
    }

    public boolean SearchRecord(node root, int iNo)
    {
        boolean iAns = false;

        if(root == null)
        {
            return false;
        }
        else
        {
            while(root != null) {
                if(iNo < root.Data)
                {
                    root = root.left;
                }
                else if(iNo > root.Data)
                {
                    root = root.right;
                }
                else {
                    iAns = true;
                    break;
                }
            }
        }
        return iAns;
    }

    public node DeleteNode(node root, int iNo)
    {
        if(root == null)
        {
            return null;
        }

        if(iNo < root.Data)
        {
            root.left = DeleteNode(root.left, iNo);
        }
        else if(iNo > root.Data)
        {
            root.right = DeleteNode(root.right, iNo);
        }
        else
        {
            if(root.left == null || root.right == null)
            {
                node temp;
                if(root.left != null)
                {
                    temp = root.left;
                }
                else
                {
                    temp = root.right;
                }

                return temp;
            }
            else
            {
                node Predecessor = Predecessor(root);
                root.Data = Predecessor.Data;
                root.left = DeleteNode(root.left, Predecessor.Data);
                return root;
            }
        }

        return root;
    }

    public node Predecessor(node root)
    {
        if(root == null)
        {
            return null;
        }

        node temp = root.left;

        while(temp.right != null)
        {
            temp = temp.right;
        }

        return temp;

    }

    public static void main(String[] args)
    {
        boolean iRet;
        int iChoice;
        int iValue = 1;
        int No;
        node Start = null;
        BST obj = new BST();
        Scanner Obj = new Scanner(System.in);
        while(iValue != 0)
        {
            System.out.println("-----------------------------------");
            System.out.println("1: Create An BST");
            System.out.println("2: Delete An Node From BST");
            System.out.println("3: Insert An Node In BST");
            System.out.println("4: Search A Node From BST");
            System.out.println("5: Display In The PreOrder Manner");
            System.out.println("6: Display In The PostOrder Manner");
            System.out.println("7: Display In The InOrder Manner");
            System.out.println("8: Exit From The Application");
            System.out.println("-----------------------------------");
            System.out.println("Enter The Choice : -");
            iChoice = Obj.nextInt();
            switch (iChoice)
            {
                case 1: case 3:
                    System.out.println("Enter the element that you want to add in the BST: -");
                    No = Obj.nextInt();
                    Start = obj.Insert(Start, No);
                    break;
                case 2:
                    System.out.println("Enter the element that you want to delete from the BST: -");
                    No = Obj.nextInt();
                    Start = obj.DeleteNode(Start, No);
                    System.out.println("Deleted element from the BST = "+Start.Data);
                    break;
                case 4:
                    System.out.println("Enter the element that you want to search in the BST: -");
                    No = Obj.nextInt();
                    iRet = obj.SearchRecord(Start, No);
                    if (!iRet) {
                        System.out.println("Element not present in the given BST");
                    } else {
                        System.out.println("Element present in the given BST");
                    }
                    break;
                case 5:
                    System.out.println("Elements from the BST in the Preorder manner: -");
                    obj.PreOrder(Start);
                    break;
                case 6:
                    System.out.println("Elements from the BST in the Postorder manner: -");
                    obj.PostOrder(Start);
                    break;
                case 7:
                    System.out.println("Elements from the BST in the Inorder manner: -");
                    obj.InOrder(Start);
                    break;
                case 8:
                    System.out.println("Thank You For Using Our Application");
                    iValue = 0;
                    break;
                default:
                        System.out.println("Undefined Choice Has Been Entered");
                    break;
            }
        }
    }
}

























