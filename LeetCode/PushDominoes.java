class Solution {
    char[] arr = new char[0];
    String dominoes = "";
    public String pushDominoes(String dominoes) {
        arr = new char[dominoes.length()];
        for (int i = 0; i < dominoes.length(); i++) {
            arr[i] = dominoes.charAt(i);
        }

        this.dominoes = dominoes;
        halper(0);
        System.out.println(new String(arr));
        // Do a left to right sweep and knock down . until we see a L or S
        for (int i = 0; i < arr.length;) {
            if (arr[i] == 'R') {
                while (i < arr.length && (arr[i] != 'L' && arr[i] != 'S')) {
                    arr[i] = 'R';
                    i++;
                }
            } else {
                i++;
            }
        }
        
        for (int i = arr.length - 1; i >= 0;) {
            if (arr[i] == 'L') {
                while (i >= 0 && (arr[i] != 'R' && arr[i] != 'S')) {
                    arr[i] = 'L';
                    i--;
                }
            } else {
                i--;
            }
        }
        
        for (int i = 0; i < arr.length;) {
            if (arr[i] == 'S') {
                arr[i] = '.';
            }
            i++;
        }
        return new String(arr);
    }
    
    private void halper(int startIndex) {
        if (startIndex >= arr.length) {
            return;
        }
        Integer lastRight = null;
        // Find first right
        for (int i = startIndex; i < arr.length; i++) {
            if (dominoes.charAt(i) == 'R') {
                lastRight = i;
                break;
            }
        }
        if (lastRight != null) {
            for (int i = lastRight; i < arr.length; i++) {
                if (dominoes.charAt(i) == 'R') {
                    lastRight = i;
                } else if (dominoes.charAt(i) == 'L') {
                    if ((i - lastRight + 1) % 2 == 0) {
                        arr[((i - lastRight) / 2) + lastRight] = 'R';
                        arr[(i - lastRight) / 2 + 1 + lastRight] = 'L';
                    } else {
                        // S =  stand
                        arr[((i - lastRight) / 2) + lastRight] = 'S';
                    }
                    halper(i + 1);
                    break;
                }
            }
        }
    }
}
