package task2;

public class Main {

    public static void main(String[] args){
        WordMap wordMap = new WordMap();

        wordMap.parse("""
                Lorem      ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed felis eget velit aliquet sagittis id consectetur. A arcu cursus vitae congue mauris rhoncus aenean vel elit. Non enim praesent elementum facilisis leo. Nisl suscipit adipiscing bibendum est ultricies integer quis auctor elit. Eu facilisis sed odio morbi quis commodo. Pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus. Auctor eu augue ut lectus arcu. Dictum non consectetur a erat nam at. Purus sit amet luctus venenatis lectus. Sed egestas egestas fringilla phasellus faucibus. Dolor sed viverra ipsum nunc aliquet. Placerat orci nulla pellentesque dignissim enim sit amet. Erat nam at lectus urna duis convallis convallis tellus id. Augue mauris augue neque gravida in fermentum et sollicitudin. Nam libero justo laoreet sit.
                                
                Sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper eget. Sit amet est placerat in egestas erat. Eu volutpat odio facilisis mauris sit. Faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis. Justo eget magna fermentum iaculis eu non diam phasellus. Urna id volutpat lacus laoreet non curabitur gravida arcu. Eu ultrices vitae auctor eu augue ut lectus arcu. Justo laoreet sit amet cursus. Viverra suspendisse potenti nullam ac tortor vitae purus. Ornare aenean euismod elementum nisi.
                """);

        wordMap.parse("""
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ornare suspendisse sed nisi lacus sed viverra tellus in. Turpis in eu mi bibendum neque egestas. Ultrices sagittis orci a scelerisque purus semper eget. Eu ultrices vitae auctor eu augue. Nulla malesuada pellentesque elit eget gravida cum sociis natoque penatibus. Et malesuada fames ac turpis egestas integer. Nisl tincidunt eget nullam non. Vel quam elementum pulvinar etiam non quam lacus. Odio tempor orci dapibus ultrices. Amet est placerat in egestas erat imperdiet sed euismod. Cursus eget nunc scelerisque viverra mauris in aliquam. Viverra mauris in aliquam sem fringilla ut morbi. Odio tempor orci dapibus ultrices in iaculis. Porta non pulvinar neque laoreet suspendisse interdum consectetur libero id. Non nisi est sit amet facilisis magna etiam.
                                
                Enim sit amet venenatis urna cursus. Augue eget arcu dictum varius duis at consectetur lorem. Maecenas accumsan lacus vel facilisis volutpat est velit. Elementum nibh tellus molestie nunc non blandit. Blandit volutpat maecenas volutpat blandit. Sem et tortor consequat id porta nibh venenatis cras sed. Scelerisque viverra mauris in aliquam sem fringilla. Augue eget arcu dictum varius duis at consectetur lorem. Pulvinar mattis nunc sed blandit libero volutpat. Porttitor rhoncus dolor purus non enim. Aliquam faucibus purus in massa tempor nec feugiat.
                                
                Faucibus ornare suspendisse sed nisi. Vitae auctor eu augue ut lectus. Enim sit amet venenatis urna cursus eget nunc scelerisque viverra. Pellentesque sit amet porttitor eget dolor. Amet consectetur adipiscing elit pellentesque habitant. Non pulvinar neque laoreet suspendisse. Mattis rhoncus urna neque viverra. At consectetur lorem donec massa sapien faucibus et. Est velit egestas dui id ornare arcu odio ut sem. Sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Nec dui nunc mattis enim ut tellus elementum. Orci eu lobortis elementum nibh tellus. Donec enim diam vulputate ut. Maecenas pharetra convallis posuere morbi leo urna. Felis donec et odio pellentesque diam volutpat commodo. Vestibulum morbi blandit cursus risus at ultrices mi tempus imperdiet. Faucibus turpis in eu mi bibendum.
                """);

        System.out.println(wordMap.getCount("sit"));
        System.out.println(wordMap.getCount("AAA"));

        System.out.println(wordMap.getUniqueWords());

        wordMap.printWordCounts();

        wordMap.reset();
        System.out.println(wordMap.getUniqueWords());
    }
}
