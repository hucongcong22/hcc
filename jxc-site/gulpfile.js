var gulp = require('gulp');
var concat = require('gulp-concat');
var cleanCSS = require('gulp-clean-css');
var uglify = require('gulp-uglify');
var imagemin = require('gulp-imagemin');
// gulp.task("taskName",function(){
//     // 把1.js和2.js合并压缩为main.js，输出到dest/js目录下
//     gp.src(['./WebConetnt/dist/js/common.js']).pipe(concat('common.js')).pipe(uglify()).pipe(gulp.dest('./dist/min/js'));
// })

gulp.task('min-js', function () {
    // 1. 找到文件
    gulp.src('./WebContent/dist/js/*.js')
    // 2. 压缩文件
        .pipe(uglify({mangle: false}))
        // 3. 另存压缩后的文件
        .pipe(gulp.dest('./WebContent/dist-min/js/'))
})

gulp.task('min-css', function () {
    // 1. 找到文件
    gulp.src('./WebContent/dist/css/*.css')
    // 2. 压缩文件
        .pipe(cleanCSS())
        // 3. 另存压缩后的文件
        .pipe(gulp.dest('./WebContent/dist-min/css/'))
})

gulp.task('test-min-js', function () {
    // 1. 找到文件
    gulp.src('./WebContent/dist/js/common.js')
    // 2. 压缩文件
        .pipe(uglify({mangle: false}))
        // 3. 另存压缩后的文件
        .pipe(gulp.dest('./WebContent/dist-min/js/'))
})

gulp.task('test-min-img', function () {
    // 1. 找到图片
    gulp.src('./WebContent/dist/img/*.{png,jpg,ico}')
    // 2. 压缩图片
        .pipe(imagemin({
            interlaced: true,
            progressive: true,
            optimizationLevel: 5,
            svgoPlugins: [{removeViewBox: true}]
        }))
        // 3. 另存压缩后的文件
        .pipe(gulp.dest('./WebContent/dist-min/img/'))
})

gulp.task('default', ['min-js', 'min-css'])