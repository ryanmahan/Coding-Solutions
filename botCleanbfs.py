#!/usr/bin/python

from functools import reduce

# Head ends here
def next_move(posr, posc, board):
      n = list(reduce(lambda x, y: x+y, board)).count("d")
  #print(board[2][1])
      nextD = None
  #for i in range(n):
      if nextD == None:
          nextD = search(posr, posc, board, [], [], [])
      else:
          nextD = search(posr, posc, board, [], [], nextD["cleaned"])
      #print(nextD)
      while posr != nextD["row"]:
          if posr < nextD["row"]:
              posr += 1
              print("DOWN")
          if posr > nextD["row"]:
              posr -= 1
              print("UP")
      while posc != nextD["col"]:
          if posc < nextD["col"]:
              posc += 1
              print("RIGHT")
          if posc > nextD["col"]:
              posc -= 1
              print("LEFT")
          if board[posr][posc] == "d":
              print("CLEAN")
        
       

def search(posr, posc, board, queue, off, cleaned):
    #print(posr, posc)
    #print(off)
    
    if board[posr][posc] == "d" and cleaned.count([posr, posc]) == 0:
        cleaned.append([posr, posc])
        return {"row": posr, "col": posc, "off": off, "queue": queue, "cleaned": cleaned}
    off.append([posr, posc])
    for i in [-1,1]:
        if (posr+i > 0 and posr+i < (len(board))):
            queue.insert(0, [posr+i, posc])
        if posc+i > 0 and posc+i < (len(board)):
            queue.insert(0, [posr, posc+i])
    if len(queue) > 0:
        next_call = queue.pop()
        while off.count(next_call) > 0:
            next_call = queue.pop()
        return search(next_call[0], next_call[1], board, queue, off, cleaned)      
    
    
# Tail starts here
if __name__ == "__main__":
    pos = [int(i) for i in input().strip().split()]
    board = [[j for j in input().strip()] for i in range(5)]
    next_move(pos[0], pos[1], board)
