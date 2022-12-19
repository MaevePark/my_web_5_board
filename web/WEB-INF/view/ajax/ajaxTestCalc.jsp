<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 계산기</title>
<link href="<%=request.getContextPath()%>/css/reset.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.js"></script>
<style>
   .checkedItems{
       border: 1px solid black;
       width: 500px;
       height: 200px;
   }
   .selecedItem > .btn_delete {
       cursor: pointer;
   }
</style>
<script>
    let maxCheckboxCnt = 5;
    $(function(){
        // node 생성
        for(i=0; i<maxCheckboxCnt; i++){
            var checkboxEle = '<input type="checkbox" class="item" id="food_'+i+'">';
            checkboxEle += '<label for="food_'+i+'">메뉴_'+(i+1)+'</label>';
            checkboxEle += '&nbsp;&nbsp;&nbsp;';
            $(".checkboxs").append(checkboxEle);
        }

        // event 등록 --> 콘솔로그로 이벤트 등록이 잘됐는지 확인
        // 1 . #allCheck 클릭 (전체)
        $("#allCheck").click(function() { 
            // console.log('#allCheck 클릭됨');
            var isAllChecked = $(this).prop("checked");  // 전체선택 체크상태
            $(".item").each( function(){
                var isItemChecked = $(this).prop("checked"); // item 체크상태
                if(isItemChecked != isAllChecked){  // item 체크상태와 전체선택 체크상태가 다르다면 수정해줘야함.
                    $(this).prop("checked", isAllChecked);
                    updateList($(this), isAllChecked);
                }
            }  );
        });

        // 2 . #revCheck 클릭 (반대)  - item의 체크의 반대로 설정
        $("#revCheck").click(function() { 
            // console.log('#revCheck 클릭됨');
            // var isChecked = $(".item").eq(0).prop("checked");
            // $(".item").eq(0).prop("checked", !isChecked);
            // 0, 1, 2,3,4
            $.each( $(".item") , function(){
                var isChecked = $(this).prop("checked");
                $(this).prop("checked", !isChecked);
                updateList($(this), !isChecked); 
            }  );
            checkAllHandler();
        });

        // 3 . .item 클릭 (각각)  - 전체선택 체크 여부를 설정
        $(".item").change(function() {
            // console.log('item 바뀜'+ this);
            // console.log(this);
            checkAllHandler();
            updateList($(this), $(this).prop("checked"));
         });
       

        // 4. item들의 체크상태에 따라 전체선택의 체크여부가 설정되는 것은 여러번 수행되므로 함수로 만들어둠.
        function checkAllHandler(){
            // console.log("checkAllHandler 호출됨");
            // console.log('item 체크수 '+ $(".item:checked").length);
            var checkedCnt = $(".item:checked").length;
            if(checkedCnt == maxCheckboxCnt){
                $("#allCheck").prop("checked", true);
            } else {
                $("#allCheck").prop("checked", false);
            }
        }

        // 5. item element, checked여부 매개인자로 checkedItems에 추가/삭제
        function updateList($ele, isChecked){
            // console.log($ele.prop("id"));
            var menuName = $ele.next().text();
            var menuId = $ele.prop("id");
            if(isChecked){
                var htmlEle = '<div class="selecedItem" id="'+menuId+'"><span>'+menuName+'</span>';
                    htmlEle += '<span class="btn_delete">&#9746;</span></div>';
                // console.log(htmlEle);
                $(".checkedItems").append(htmlEle);

                // 중요 !!!
                // 6. 새로 생성된 .selecedItem > img에 이벤트 deleteSelectedItem 등록하기
                addEventAddedNode(".selecedItem > .btn_delete", deleteSelectedItem);
            } else {  // 체크 해제되었다면 
                $(".checkedItems").find("#"+menuId).remove();
            }
        }
        // 6. 새로 생성된 node들(addedNodeSelector)에 이벤트 (callbackFunction)등록
        function addEventAddedNode(addedNodeSelector, callbackFunction){
            // console.log("addEventAddedNode");
            // console.log(addedNodeSelector);
            // console.log(callbackFunction);
            $(addedNodeSelector).click(callbackFunction);
        }
        function deleteSelectedItem(){
            // console.log(this);
            // console.log($(this).parent().prop("id"));
            var menuId = $(this).parent().prop("id");
            $("input[id="+menuId+"]").prop("checked", false);
            $(this).parent().remove();
            checkAllHandler();
        }
    });
</script>





<script>
$(loadedHandler);  // 매개인자로 넣은 함수를 로딩이 끝나고 나면 그때 호출

function loadedHandler(){
	$("#btnSend").on("click",btnSendClickHandler);
}

function btnSendClickHandler(){
	var num1 = $("#num1").val();
	var num2 = $("#num2").val();
	var oper = $("#oper").val();
	
	$.ajax({
		  type:"post"
		, url:"test/calc.lo"
		, data: {n1:num1, n2:num2, oper:oper}
		, dataType:"json"
		, success: btnSendSuccessCb
		, error : ajaxErrorCb
		});
}

function btnSendSuccessCb( aaa ){
	console.log(aaa);
	console.log(aaa.result);
	console.log(aaa["result"]);
}
function ajaxErrorCb( request, status, error ){
	alert("code:"+request.status+"\nmessage:"+request.responseText+"\nerror:"+error);
}
</script>
</head>
<body>
<div>
        <label for="allCheck">전체선택</label><input type="checkbox" id="allCheck">
        &nbsp;&nbsp;&nbsp;
        <label for="revCheck">반대선택</label><input type="checkbox" id="revCheck">
    </div>
    <div class="checkboxs">
    </div>
    <div class="checkedItems">
    </div>
    <hr>



	<input type="text" id="num1">
	<select id="oper">
		<option value="add">더하기</option>
		<option value="sub">빼기</option>
		<option value="mul">곱하기</option>
		<option value="div">나누기</option>
	</select>
	<input type="text" id="num2">
	<input type="button" value="=" id="btnSend">
	<br> <hr>
	<div  id="result"></div>
</body>
</html>