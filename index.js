db.colleges.aggregate([

    {$match:{name:'ABC'}},
    
    {$project:{_id:0,name:1,country:1,city:1,students:1}},
    
    {$lookup : {
    
    from : 'courses',
    
    localField : 'name',
    
    foreignField : 'college',
    
    as :'courses1'
    
    }},
    
    
    
    {
    
    $facet: {
    
        'countingLevel' : [
    
        {$unwind : '$courses1'},
    
        {$sortByCount:'$courses1.level'}
    
        ],
    
        
    
        'YearWiseStudents' : [
    
        {$unwind : '$students'},
    
        {$project : {_id:0,name:1,country:1,city:1}}
    
        ]
    
        
    
        }    
    
    }
    
    
    
    ])
    
    
    
    