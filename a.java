import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Reset implements MouseListener{
  JButton but_arr[][]=new JButton[3][3];
  int logic_arr[][];
  Reset(JButton butt_arr[][],int arr[][]){
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++)
      but_arr[i][j]=butt_arr[i][j];
    }
    logic_arr=arr;
  }
  public void mouseExited(MouseEvent e){
  }
  public void mouseEntered(MouseEvent e){
    }
  public void mouseReleased(MouseEvent e){

  }
  public void mouseClicked(MouseEvent e){

  }
public void mousePressed(MouseEvent e){
  int c=0;
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        but_arr[i][j].setIcon(null);
        logic_arr[i][j]=0;
      }
    }
  }
}
public class a implements ActionListener{
static final JFrame f=new JFrame("TIC TaC TOE by Resd@");
static int count=0;static int play=0;
static int logic_mat[][]=new int[3][3];
static JButton but_arr[][]=new JButton[3][3];
ImageIcon x = new ImageIcon("x.jpg"); // load the image to a imageIcon
static ImageIcon o = new ImageIcon("o.jpg"); // load the image to a imageIcon
JButton temp;
int but_x;
int but_y;
  a(JButton b,int x,int y){
    temp=b;
    but_x=x;
    but_y=y;
  }

  public void actionPerformed(ActionEvent e){
  if(logic_mat[but_x][but_y]==0){
    if(play==0){
      if(count==0){
        temp.setIcon(o);
        logic_mat[but_x][but_y]=10;
        if(check_victory(10)){
          for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
              logic_mat[i][j]=2;
            }
          }
          JOptionPane.showMessageDialog(f,"Player who plays with 0 wins");
        }
          }
     else{
      temp.setIcon(x);
      logic_mat[but_x][but_y]=1;
      if(check_victory(1)){
        for(int i=0;i<3;i++){
          for(int j=0;j<3;j++){
            logic_mat[i][j]=2;
          }
        }

      JOptionPane.showMessageDialog(f,"Player who plays with x wins");
        }
      }
  count+=1;
  count%=2;
    }

    if(play==1){
      temp.setIcon(x);
      logic_mat[but_x][but_y]=1;
        simpulate_pc();
      }
    }
  }
static int move=0;

public static void simpulate_pc(){
  if(move==0){
          but_arr[0][0].setIcon(o);
          logic_mat[0][0]=10;
          move++;
        }
  else if(move==1&&logic_mat[1][1]==0){
    if(logic_mat[0][1]==1||logic_mat[0][2]==1||logic_mat[2][1]==1||logic_mat[2][2]==1){
      but_arr[2][0].setIcon(o);
      logic_mat[2][0]=10;
    }
    else{
      but_arr[0][2].setIcon(o);
      logic_mat[0][2]=10;
    }
    move++;
  }
  else if(move==1&&logic_mat[1][1]==1){
    but_arr[2][2].setIcon(o);
    logic_mat[2][2]=10;
    move=4;
  }
  else if(move==2)
   {
    find_best_move(0);
  }
  else if(move==5)
    win_in_one();
    else if(move==7)
      tie();
  else if(move==4){
    if(logic_mat[0][2]==1)
      {
        but_arr[2][0].setIcon(o);
        logic_mat[2][0]=10;
        move=5;
      }
      else if(logic_mat[2][0]==1)
        {
          but_arr[0][2].setIcon(o);
          logic_mat[0][2]=10;
          move=5;
        }
        else{
          move=7;
        }

  }

    if(check_victory(10)){
      for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
          logic_mat[i][j]=2;
        }
      }
      JOptionPane.showMessageDialog(f,"Mortals it's 100 years before you can defeat me....");
      play=0;
    }
      }
      public static void tie(){
        if(!win_in_one())
        {for(int i=0;i<3;i++){
          for(int j=0;j<3;j++){
            if(logic_mat[i][j]==0)
            {
              logic_mat[i][j]=1;
              if(check_victory(1)){
              logic_mat[i][j]=10;
              but_arr[i][j].setIcon(o);
              break;
            }
            else
            logic_mat[i][j]=0;
          }
        }
      }
    }}
public static void find_best_move(int x){
  if(!win_in_one())
  {
    if(x==0)
    {
      if((logic_mat[0][1]==1&&logic_mat[1][0]==1)||(logic_mat[1][0]==1&&logic_mat[0][2]==1)||(logic_mat[0][1]==1&&logic_mat[2][0]==1))
      {

        logic_mat[2][2]=10;
        but_arr[2][2].setIcon(o);
      }
      else if((logic_mat[2][1]==1&&logic_mat[1][0]==1)||(logic_mat[1][0]==1&&logic_mat[2][2]==1)){
        logic_mat[0][2]=10;
        but_arr[0][2].setIcon(o);
      }
      else if(logic_mat[0][1]==1&&logic_mat[1][2]==1){
        logic_mat[2][0]=10;
        but_arr[2][0].setIcon(o);
      }
    }
  }
}
public static boolean win_in_one(){
  for(int i=0;i<3;i++)
  {
    for(int j=0;j<3;j++){
      if(logic_mat[i][j]==0)
      {
        logic_mat[i][j]=10;
        if(!check_victory(10))
        logic_mat[i][j]=0;
        else
        {
          but_arr[i][j].setIcon(o);
          return true;
        }
      }
    }
  }
return false;
}
  public static boolean check_victory(int x){
    for(int i=0;i<3;i++)
    if(logic_mat[i][0]+logic_mat[i][1]+logic_mat[i][2]==3*x)
    return true;
    for(int i=0;i<3;i++)
    if(logic_mat[0][i]+logic_mat[1][i]+logic_mat[2][i]==3*x)
    return true;
    if(logic_mat[0][0]+logic_mat[1][1]+logic_mat[2][2]==3*x)
    return true;
    if(logic_mat[0][2]+logic_mat[1][1]+logic_mat[2][0]==3*x)
    return true;
    return false;
  }
    public static void main(String args[]){

      JMenu reset=new JMenu("New Game");
      JMenu connect=new JMenu("P2P");
      JMenu pc=new JMenu("Play with pc");
      JMenuBar menu=new JMenuBar();
for(int i=0;i<3;i++){
  for(int j=0;j<3;j++){
    but_arr[i][j]=null;
  }
}
      menu.add(reset);

      menu.add(connect);
      JMenuItem Host=new JMenuItem("Host");
      JMenuItem Join=new JMenuItem("Join");

      connect.add(Host);
      connect.add(Join);
      menu.add(pc);
      menu.setBounds(0,0,400,20);
      for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){

          JButton b=new JButton();
          b.setBounds(40+100*i,40+100*j,100,100);
          b.addActionListener(new a(b,j,i));
          f.add(b);
but_arr[j][i]=b;
        }
      }
            reset.addMouseListener(new Reset(but_arr,logic_mat));
            reset.addMouseListener(new MouseAdapter() {
               public void mousePressed(MouseEvent e) {
                 play=0;
               }
               });
            pc.addMouseListener(new MouseAdapter() {
               public void mousePressed(MouseEvent e) {
                 for(int i=0;i<3;i++){
                   for(int j=0;j<3;j++){
                     but_arr[i][j].setIcon(null);
                     logic_mat[i][j]=0;
                   }
                 }
                     count=0;
                     play=1;
                     move=0;
                               JOptionPane.showMessageDialog(f,"Mortals you can not defeat me....");
                    simpulate_pc();
               }
            });
      f.add(menu);
      f.setSize(400,600);
      f.setDefaultCloseOperation(2);
      f.setLayout(null);
      f.setVisible(true);


    }
}
