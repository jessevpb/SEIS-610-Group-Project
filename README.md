# SEIS-610-Group-Project

Software Engineering SEIS 610 Group Project


SEIS 610- Software Engineering

Summer 2015

Professor Chih Lai


Group Members:

Ed Bernal

Ken Kamura

Kate Kippels

Nick Larsen

Jesse Peterson-Brandt

Paul Thyen


Our program will take a set of data and fit an equation to it. We will do this using an evolutionary computing process. Individual equations are expressed as trees and tested with respect to testing data. After testing a new generation of trees will be created and tested again. Equations which fit well are more likely to survive to the next generation. They are also more likely to cross-over part of themselves with another equation or to mutate one of their values. Once testing reaches a defined termination condition it will return the function which best fits the data. Each generation will also produce some evaluation metrics to watch the progress of the program.

## Evolutionary Computing - Array (Evcompra.java)

The nodes of the tree  are stored in an array, and as the hard limit on the depth of the tree is seven levels, the maximum number of nodes is 2^7 - 1 = 127. App.java is the driver for testing Evcompra and Node. It doesn't do much now but create a tree, populate it, and then print it out *inorder* (left tree - this node - right tree). Nodes are of two types, **operand** nodes that have no children (subtrees) and **operator** nodes that have both left and right children. The topmost node, the *root*, is always an operand node, and the bottom nodes are always operand nodes, so no dangling operators with nothing to operate on.


## Changes 2015-06-23

* Evcompra.treeStr is now a post-order traversal of the tree.
* App.java lines 50 - 55 below:

```java
int len = evct2.treeStr.length();

for(int i = 0; i < len; i++ )
{
System.out.print("["+i+"]:" + evct2.treeStr.charAt(i) );
}
```
Shows how to traverse a string by using `str.charAt(i)`. Avoid a repeated function call by saving the value of str.length() and using that in the `for()` loop. The processing of each character should go within the statement block.

## Changes 6-26
Ed Bernal has been working on the files in the "seis610" folder. The files are all in the "seis610.group" package.
* Evcompra.evaluate(x) now evaluates the Evcompra.treeStr using a stack, visible from App.java
* Still need
  - fitness() of the tree
  - crossover() of two trees
  - mutation() of the tree