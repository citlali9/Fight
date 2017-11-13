/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import java.util.Scanner;

/**
 *
 * @author citlalli
 */
public class Arbol {

    class Node {
        char key;
        Node left, right;
 
        public Node(char item) {
            key = item;
            left = right = null;
        }
    }
    
    Node root;
    
    Arbol() { 
        root = null; 
    }
 
    void insert(char key) {
       root = insertRec(root, key);
    }
     
    
    Node insertRec(Node root, char key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }       
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
       
        return root;
    }
 
    
    void preorder()  {
       preorderRec(root);
    }
 
    
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key);
            preorderRec(root.left);
            
            preorderRec(root.right);
        }
    }
 
    // Driver Program to test above functions
    public static void main(String[] args) {
        
        Arbol tree = new Arbol();    
       
        System.out.println("Bienvenido");
        System.out.println("Ingresa los datos");
        Scanner sc=new Scanner(System.in);
        String ingresa;
        String cadena="";
        String entrada="$";
        do{
            ingresa=sc.nextLine();
            if(ingresa.equals(entrada)){
                break;
            }
            cadena+=ingresa;
        
        }while(!ingresa.equals(entrada));
        int total=cadena.length();
        
        for(int i=total-1;i>=0;i--){
            tree.insert(cadena.charAt(i));            
        }
        
        tree.preorder();
    }
}
