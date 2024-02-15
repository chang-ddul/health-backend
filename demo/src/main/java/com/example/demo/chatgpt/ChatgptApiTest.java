package com.example.demo.chatgpt;

public class ChatgptApiTest {

    public static void main(String[] args) {
        String prompt = """
            내가 다이어트를 할 건데 하루에 1900Kcal에 맞춰서 하루치 식단을 짜줘.
            아래 예시처럼 아침메뉴, 아침메뉴 열량, 점심메뉴, 점심메뉴 열량, 저녁메뉴, 저녁메뉴 열량을 엔터로 구분해서 작성해줘.
            밑의 예시랑 완전히 똑같은 형식으로 작성해줘, 앞에 아침, 점심, 저녁 이런거 붙여줄 필요없이 완벽하게 밑의 예시랑 똑같은 형식으로 작성 부탁해.
            내 질문에 어떤 미사여구도 붙이지 말고 오직 대답만 해줘.
            1900Kcal와 최대한 비슷하게 식단을 짜달라고 얘기했어.
            앞에 아침, 점심, 저녁 이런거 붙여줄 필요없이 완벽하게 밑의 예시랑 똑같은 형식으로 작성 부탁해
            앞에 아침, 점심, 저녁 이런거 붙여줄 필요없이 완벽하게 밑의 예시랑 똑같은 형식으로 작성 부탁해
            앞에 아침, 점심, 저녁 이런거 붙여줄 필요없이 완벽하게 밑의 예시랑 똑같은 형식으로 작성 부탁해

            예시)
            메뉴A(용량g),메뉴B(용량g)..
            ???kcal
            메뉴A(용량g),메뉴B(용량g)..
            ???kcal
            메뉴A(용량g),메뉴B(용량g)..
            ???kcal""";
        prompt = prompt.replace("\n", "\\n");

        String string = ChatGPTAPI.chatGPT(prompt);
        System.out.println(string);
    }
}
