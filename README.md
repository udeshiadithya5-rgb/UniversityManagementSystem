# 🎓 University Student Record and Campus Route Management System
# 

---

## 📋 Project Information 

| Field | Details |
|-------|---------|
| **Module** | CIT300 - Data Structures and Algorithms |
| **Assignment** | Graded Practical Assignment 1 (Week 10) |
| **Project Title** | University Student Record and Campus Route Management System |
| **Language** | Java (Console Application) |
| **Weight** | 10% of Final Module Grade |
| **Deadline** | 29th September |
| **Repository** | https://github.com/your-username/UniversityManagementSystem |

---

## 👥 Group Members 

> **IMPORTANT:** All group member details must be recorded correctly.

### Member 1 

| Field | Details |
|-------|---------|
| **Student ID** | 23DA2-0366 |
| **Name** | K.A.D.U. Adithya |
| **Assigned Responsibility** | Linked List Implementation and Student Record Management |
| **Individual Contribution** | • Designed and implemented `Student.java` model class with encapsulation<br>• Created `StudentNode.java` for linked list node structure<br>• Implemented `StudentLinkedList.java` with full CRUD operations:<br>&nbsp;&nbsp;- `addStudent()` - Add new student with duplicate ID validation<br>&nbsp;&nbsp;- `findStudent()` - Search by Student ID<br>&nbsp;&nbsp;- `updateStudent()` - Update existing student details<br>&nbsp;&nbsp;- `deleteStudent()` - Remove student with proper link management<br>&nbsp;&nbsp;- `displayAll()` - Display all records with formatting<br>• Implemented input validation for marks range (0-100)<br>• Tested linked list operations with edge cases |

### Member 2 

| Field | Details |
|-------|---------|
| **Student ID** | 23DA2-0155 |
| **Name** | W.A.H. Maduranga |
| **Assigned Responsibility** | Stack and Queue Implementation and Related Operations |
| **Individual Contribution** | • Implemented `ActionStack.java` using Java's `Stack` class:<br>&nbsp;&nbsp;- `pushAction()` - Record actions to history<br>&nbsp;&nbsp;- `popAction()` - Undo last action<br>&nbsp;&nbsp;- `peekAction()` - View last action<br>&nbsp;&nbsp;- `displayHistory()` - Display all recent actions<br>&nbsp;&nbsp;- Implemented MAX_HISTORY limit (20 actions)<br>• Implemented `ServiceQueue.java` using Java's `LinkedList` as Queue:<br>&nbsp;&nbsp;- `addRequest()` - Add service request to queue<br>&nbsp;&nbsp;- `processNextRequest()` - FIFO processing<br>&nbsp;&nbsp;- `displayPendingRequests()` - Show all pending requests<br>&nbsp;&nbsp;- Created inner `ServiceRequest` class with auto-incrementing ID<br>• Tested stack LIFO and queue FIFO behaviors |

### Member 3 

| Field | Details |
|-------|---------|
| **Student ID** | 23DA2-0216 |
| **Name** | W.I. Sandakelum |
| **Assigned Responsibility** | BST/AVL Tree Implementation and Hashing/Search Functionality |
| **Individual Contribution** | • Implemented `TreeNode.java` for BST node structure<br>• Implemented `StudentBST.java` (Binary Search Tree):<br>&nbsp;&nbsp;- `insert()` - Recursive insertion with key comparison<br>&nbsp;&nbsp;- `search()` - Recursive search by Student ID<br>&nbsp;&nbsp;- `displayInOrder()` - Ascending order traversal<br>&nbsp;&nbsp;- `displayPreOrder()` - Pre-order traversal<br>• Implemented `StudentHashTable.java` using chaining:<br>&nbsp;&nbsp;- `hashFunction()` - Polynomial rolling hash for string keys<br>&nbsp;&nbsp;- `insert()` - Insert with collision handling<br>&nbsp;&nbsp;- `search()` - O(1) average-case lookup<br>&nbsp;&nbsp;- `delete()` - Remove from hash table<br>&nbsp;&nbsp;- `displayStats()` - Show load factor and collision stats<br>• Used prime number 101 for table size to minimize collisions |

### Member 4 

| Field | Details |
|-------|---------|
| **Student ID** | 23DA2-0255 |
| **Name** | Manodya Ravikubura |
| **Assigned Responsibility** | Graph Implementation, Campus Locations, Connections, and BFS/DFS Traversal |
| **Individual Contribution** | • Implemented `Graph.java` using Adjacency List:<br>&nbsp;&nbsp;- `addLocation()` - Add campus location (vertex)<br>&nbsp;&nbsp;- `removeLocation()` - Remove location and all edges<br>&nbsp;&nbsp;- `addConnection()` - Add undirected edge between locations<br>&nbsp;&nbsp;- `removeConnection()` - Remove edge<br>&nbsp;&nbsp;- `displayGraph()` - Show complete campus network<br>&nbsp;&nbsp;- `displayNeighbors()` - Show adjacent locations<br>• Implemented `GraphTraversal.java`:<br>&nbsp;&nbsp;- `bfs()` - Breadth-First Search using Queue<br>&nbsp;&nbsp;- `dfs()` - Depth-First Search (recursive)<br>&nbsp;&nbsp;- `findShortestPath()` - BFS-based shortest path finder<br>• Used HashMap and ArrayList for efficient adjacency list storage |

### All Members 

| Field | Details |
|-------|---------|
| **Student IDs** | 23DA2-0366, 23DA2-0155, 23DA2-0216, 23DA2-0255 |
| **Names** | K.A.D.U. Adithya, W.A.H. Maduranga, W.I. Sandakelum, Manodya Ravikubura |
| **Assigned Responsibility** | Integration, Validation, Testing, Documentation, GitHub Collaboration |
| **Individual Contribution** | • Jointly integrated all modules in `Main.java`<br>• Implemented complete menu-driven console interface (16 options)<br>• Added comprehensive input validation for all operations<br>• Created sample data loader for demonstration<br>• Performed integration testing across all data structures<br>• Debugged cross-module issues<br>• Prepared documentation and README<br>• Managed GitHub branches, commits, and pull requests<br>• Recorded and merged demonstration video |

---

## Project Objective 

Develop a **Java console application** that manages university student records and represents connections between campus locations. The system demonstrates the practical use of:

- **Linked Lists** - Student record storage
- **Stacks** - Recent actions / Undo history
- **Queues** - Service requests in FIFO order
- **BST/AVL Trees** - Ordered student organization
- **Hashing** - Fast student ID lookup
- **Graphs** - Campus location network with BFS/DFS traversal

---

## System Requirements 

| # | Requirement | Implementation | Status |
|---|-------------|----------------|--------|
| 1 | Store student records (ID, Name, Programme, Marks) | `Student.java` | Done
| 2 | Linked list for student management | `StudentLinkedList.java` | Done
| 3 | Stack for recent actions/undo | `ActionStack.java` | Done
| 4 | Queue for service requests (FIFO) | `ServiceQueue.java` | Done
| 5 | BST for organizing students by ID | `StudentBST.java` | Done
| 6 | Hashing for efficient ID search | `StudentHashTable.java` | Done
| 7 | Graph for campus locations | `Graph.java` | Done
| 8 | Adjacency list representation | `Graph.java` | Done
| 9 | Add/remove locations & connections | `Graph.java` | Done
| 10 | Display campus network | `Graph.displayGraph()` | Done
| 11 | BFS/DFS traversal | `GraphTraversal.java` | Done
| 12 | CRUD operations for students | `StudentLinkedList.java` | Done
| 13 | Menu-driven console interface | `Main.java` | Done
| 14 | Input validation & error handling | All classes | Done

---

## 🗂️ Detailed Project Structure 
