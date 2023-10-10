$(document).ready(function() {
    // 현재 페이지 URL에서 포스트 번호를 추출합니다.
    var currentURL = window.location.pathname;
    var match = currentURL.match(/\/board\/read\/(\d+)/);
    
    if (match) {
        // URL에서 추출한 포스트 번호를 가져옵니다.
        var posts_num = match[1];

        // 댓글 목록을 불러오고 출력하는 함수 호출
        loadCommentsList(posts_num);
    }
    
    // 댓글 목록을 불러오고 출력하는 함수
    function loadCommentsList(posts_num) {
        // AJAX 요청을 보냅니다.
        $.ajax({
            type: "GET",
            url: "/board/read/" + posts_num,
            dataType: "json",
            success: function(data) {
                // 성공적으로 데이터를 받아왔을 때 처리
                var commentsList = $("#commentsList"); // 댓글 목록을 출력할 요소 선택
                commentsList.empty(); // 기존 목록을 비웁니다.

                if (data.length === 0) {
                    commentsList.append("<li>댓글이 없습니다.</li>");
                } else {
                    $.each(data, function(index, comments) {
                        // 각 댓글을 목록에 추가합니다.
                        var listItem = $("<li>").text(comments.comments_content);
                        commentsList.append(listItem);
                    });
                }
            },
            error: function() {
                // 요청이 실패한 경우 처리
                alert("댓글을 불러오는데 실패했습니다.");
            }
        });
    }
});