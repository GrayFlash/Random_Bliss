class word_generator{
    int wordsCount;
    word_generator(int wordsCount){
        this.wordsCount = wordsCount;
    }

    String generate(){
        String res="";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        while(wordsCount-->0){
            String word="";
            int charCount = Math.round((float)Math.random() * 10);
            for(int i=0; i<charCount; i++){
                word += characters.charAt((int)(Math.random() * characters.length()));
            }
            res += word+" ";
        }
        return res;
    }
}