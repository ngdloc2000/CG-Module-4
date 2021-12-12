function addNewArtist() {
    let formData = new FormData();
    let name = $('#name').val();
    let dob = $('#dob').val();
    let countryside = $('#countryside').val();
    let fanpage = $('#fanpage').val();
    let job = $('#job').val();
    let file = $('#file')[0].files[0];
    formData.append('image', file);
    let newArtist = {
        name: name,
        dob: dob,
        countryside: countryside,
        fanpage: fanpage,
        file: formData,
        job: {
            id: job
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newArtist),
        url: "/api/artists",
        success: successHandler
    });
    event.preventDefault();
}

function searchByJob() {
    let idJob = $('#searchByJob').val();
    $.ajax({
        type: "GET",
        url: "/api/artists/job/" + idJob,
        success: function (data) {
            let content = '<thead>' +
                '    <tr>\n' +
                '        <th>Ảnh đại diện</th>\n' +
                '        <th>Tên nghệ sĩ</th>\n' +
                '        <th>Ngày sinh</th>\n' +
                '        <th>Quê quán</th>\n' +
                '        <th>Fanpage</th>\n' +
                '        <th>Nghề nghiệp</th>\n' +
                '        <td>Delete</td>\n' +
                '        <td>Edit</td>\n' +
                '    </tr>' +
                '   </thead>';
            for (let i = 0; i < data.length; i++) {
                content += getArtist(data[i]);
            }
            document.getElementById('artistList').innerHTML = content;
        }
    });
}

function getArtist(artist) {
    return `<tr>` +
        `<td><img width="100" height="100" src="/image/${artist.image}"></td>` +
        `<td> ${artist.name}</td>` +
        `<td>${artist.dob}</td>` +
        `<td>${artist.countryside}</td>` +
        `<td>${artist.fanpage}</td>` +
        `<td>${artist.job?.name}</td>` +
        `<td><button value="${artist.id}" onclick="showFormEdit(this)">Edit</button></td>` +
        `<td><button value="${artist.id}" onclick="deleteArtist(this)">Delete</button></td>` +
        `</tr>`;
}

function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: "/api/artists",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            let content = '<thead>' +
                '    <tr>\n' +
                '        <th>Ảnh đại diện</th>\n' +
                '        <th>Tên nghệ sĩ</th>\n' +
                '        <th>Ngày sinh</th>\n' +
                '        <th>Quê quán</th>\n' +
                '        <th>Fanpage</th>\n' +
                '        <th>Nghề nghiệp</th>\n' +
                '        <td>Delete</td>\n' +
                '        <td>Edit</td>\n' +
                '    </tr>' +
                '   </thead>';
            for (let i = 0; i < data.length; i++) {
                content += getArtist(data[i]);
            }
            document.getElementById('artistList').innerHTML = content;
        }
    });
}