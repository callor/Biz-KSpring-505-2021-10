
// 바닐라 JS
// document.addEventListener("DOMContentLoaded",function(){
// })

// JQuery 사용할때
// $(document.ready(function(){   }))
// $(function(){

// })
$(()=>{
    // JQuery 코드 영역
    // $("table.buyer_list tr").click(function() {  })
    /*
        class 가 buyer_list 인 table 내( > )의
        tr 중에 한개가 클릭되면 함수를 실행하라

        data-id 값을 getter 하여
        alert 창에 표시하라
    */
    // $("table.buyer_list tr").on("click",function(){
    //    const id = $(this).data("id") // data-id 를 getter 하기
    //    location.href="/detail?userid=" + id
    // })

    // const tableClickHandler = () =>{  }
    // const tableClickHandler = function() {  }
    function tableClickHandler() {
        const id = $(this).data("id")
        location.href = `${rootPath}/buyer/detail?userid=${id}`
    }

    // 이미 생성된 DOM 에는 정상적으로 event 가 적용된다
    // 동적으로 추가된 append() DOM 에는 event 를 적용할 수 없다
    // $("table.buyer_list tr").on("click", tableClickHandler)

    // 동적으로 추가된 table tr 요소에 event 를 설정할때 사용
    $(document).on("click",
        "table.buyer_list tr",
        tableClickHandler)

})
