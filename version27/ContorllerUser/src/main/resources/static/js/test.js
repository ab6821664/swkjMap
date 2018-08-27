layer.popupTemplate.content = [{
    type: "fields",
    fieldInfos: [{
        fieldName: "Point_Count",
        visible: false,
        label: "Count of Points",
        format: {
            places: 0,
            digitSeparator: true
        }
    }, {
        fieldName: "relationships/0/Point_Count_COMMON",
        visible: true,
        label: "Sum of species tree count",
        format: {
            places: 0,
            digitSeparator: true
        },
        statisticType: "sum"
    }]
}, {
    type: "text",
    text: "There are {Point_Count} trees within census block {BLOCKCE10}"
}, {
    type: "media",
    mediaInfos: [{
        title: "<b>Count by type</b>",
        type: "pie-chart",
        caption: "",
        value: {
            theme: "Grasshopper",
            fields: [ "relationships/0/Point_Count_COMMON" ],
            normalizeField: null,
            tooltipField: "relationships/0/COMMON"
        }
    }, {
        title: "<b>Welcome to Beverly Hills</b>",
        type: "image",
        value: {
            sourceURL: "http://www.beverlyhills.org/cbhfiles/storage/files/13203374121770673849/122707_039r_final.jpg"
        }
    }]
}, {
    type: "attachments"
}];