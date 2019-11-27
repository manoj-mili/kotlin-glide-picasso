## kotlin-coroutine-glide-picasso
## Simple android app using displaying images using glide and picasso and retrofit implementation using kotlin-coroutines 

App Uses Pixabay API to fetch Images for more details please use -> [Pixabay](https://pixabay.com/api/docs/)
Please generate api from pixabay by signing up on Pixabay its free.
Update the API_KEY in [Constants.kt](https://github.com/manoj-mili/kotlin-glide-picasso/blob/master/app/src/main/java/com/mili/glideandpicasso/util/Constants.kt)

## without coroutine
```
@GET("api/?")
    suspend fun getImages(
    @Query("key") apiKey: String,
    @Query("q") query: String,
    @Query("image_type") imageType: String,
    @Query("pretty") yesOrNo: Boolean
    ):ApiResponse
    
fun getImagesForGlideView() {
        apiService.getImages(API_KEY,"food","photo",true).enqueue(object : Callback<ApiResponse> {

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                apiResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
```  
## with coroutine

```
@GET("api/?")
    fun getImages(@Query("key") apiKey: String,
                   @Query("q") query: String,
                   @Query("image_type") imageType: String,
                   @Query("pretty") yesOrNo: Boolean): Call<ApiResponse>
                   
fun getImagesForGlideView() {
        CoroutineScope(IO).launch {
            apiResponse.postValue(apiService.getImages(API_KEY,"food","photo",true))
        }
    }
    
```
        


<p float="left">
<image src = "https://lh3.googleusercontent.com/-IdC9eAqzrEg/Xd7hU_-mFrI/AAAAAAAAH4E/mO94I0O-dQUOyJvEwrtwb-hl-v8FYeXNACK8BGAsYHg/s0/2019-11-27.jpg"
 width = 300, height = 600/>
<image src = "https://lh3.googleusercontent.com/-ei-vxxbc2CM/Xd7hUitGhvI/AAAAAAAAH4A/HUKFfxvnGBYeBsf_idde1-vFqpZN7CrXgCK8BGAsYHg/s0/2019-11-27.jpg"
 width = 300, height = 600/>
</p>
